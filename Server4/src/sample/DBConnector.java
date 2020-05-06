package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/students";
    private static String user = "root";
    private static String password = "3306";
    public static Statement statmt;
    public static ResultSet resSet;



    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Can't download the SQL class: " + e.getException());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("DB is connected to server.");
        try {
            statmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<Student> DBTableStudents()
        {
        int id = 0;
        String Surname = " ";
        String Name = " ";
        String MiddleName= " ";
        int Age = 0;
        String AverageGrade = " ";

        ArrayList<Student> students = new ArrayList<>();
        try
        {
            resSet = statmt.executeQuery("SELECT * FROM student");

            while (resSet.next())
            {
                id=resSet.getInt("id");
                Surname=resSet.getString("surname");
                Name=resSet.getString("name");
                MiddleName=resSet.getString("middle_name");
                Age=resSet.getInt("age");
                AverageGrade=resSet.getString("average_grade");
                students.add(new Student(id,Surname,Name,MiddleName,Age,AverageGrade));
                System.out.println(id + " " +Surname+" "+Name+" "+MiddleName +" "+Age+" "+AverageGrade);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    public static void insertIntoDB(String Surname, String Name, String MiddleName, int Age,String AverageGrade){

        try {
            String Query = "INSERT INTO student(surname, name, middle_name, age, average_grade) VALUES ('"+Surname+"', '"+Name+"', '"+MiddleName+"', '"+Age+"', '"+AverageGrade+"')";
            statmt.executeUpdate(Query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteFromDB(int id){

        try{
            String Query = "DELETE FROM student WHERE id = " + id;
            statmt.executeUpdate(Query);
        }catch (SQLException e){
            e.printStackTrace();}
    }

    public static void updateInDB(int id, String Surname, String Name, String MiddleName, int Age,String AverageGrade)
    {
        try{
            String Query = "UPDATE student SET surname = '"+Surname+"', name = '"+Name+"', middle_name = '"+MiddleName+"', age= '"+Age+"' , average_grade = '"+AverageGrade+"' WHERE id = "+id;
            statmt.executeUpdate(Query);
        }catch (SQLException e){
            e.printStackTrace();}
    }

    public static Connection getConnection() throws SQLException{
        if(connection != null && !connection.isClosed()) {
            return connection;
        } else connect();
        return connection;
    }
}
