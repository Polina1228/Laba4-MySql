package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateStudentController {

    @FXML
    private TextField idField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField middleNameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField averageGradeField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    public void okClick(){
        int id = Integer.parseInt(idField.getText());
        String surname = surnameField.getText();
        String name = nameField.getText();
        String middleName = middleNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String averageGrade = averageGradeField.getText();
        WorkWithServer.UpdateStudent(id,surname, name, middleName, age, averageGrade);

        cancClick();
    }

    @FXML
    public void cancClick(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
