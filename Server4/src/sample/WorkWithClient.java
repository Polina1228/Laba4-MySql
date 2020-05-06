package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkWithClient implements Runnable {

    private final Socket clientAccepted;
    private final ObjectInputStream sois;
    private final ObjectOutputStream soos;

    public WorkWithClient(Socket clientAccepted, ObjectInputStream sois, ObjectOutputStream soos) {
        this.clientAccepted = clientAccepted;
        this.sois = sois;
        this.soos = soos;
    }

    @Override
    public void run() {
        try {
            DBConnector.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.DBTableStudents();
        System.out.println(" " + clientAccepted.getInetAddress() + " " + clientAccepted.getLocalPort() + " " + clientAccepted.getPort() );

        try {
            String clientMessageRecieved = (String) sois.readObject();
            while (!clientMessageRecieved.equals("0")) {

                System.out.println("clients message: " + clientMessageRecieved);
                switch (clientMessageRecieved) {
                    case "students": {
                        ArrayList<Student> students = new ArrayList<>(DBConnector.DBTableStudents());
                        for (Student student : students) {
                            soos.writeObject(student.getId()+"&"+student.getSurname()+"&"+student.getName()+"&"+student.getMiddleName()+"&"+student.getAge()+"&"+student.getAverageGrade());
                            soos.flush();
                        }
                        soos.writeObject("end");
                        soos.flush();
                        break;
                    }
                    case "addStudent":{
                        String [] answer = ((String)sois.readObject()).split("&");
                        DBConnector.insertIntoDB(answer[0], answer[1], answer[2], Integer.parseInt(answer[3]),answer[4]);
                        break;
                    }
                    case "deleteStudent":{
                        String [] answer = ((String)sois.readObject()).split("&");
                        DBConnector.deleteFromDB(Integer.parseInt(answer[0]));
                        break;
                    }
                    case "updateStudent":{
                        String [] answer = ((String)sois.readObject()).split("&");
                        DBConnector.updateInDB(Integer.parseInt(answer[0]),answer[1], answer[2], answer[3], Integer.parseInt(answer[4]),answer[5]);
                        break;
                    }
                }

                clientMessageRecieved = (String) sois.readObject();
            }
        }catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        }
    }

}
