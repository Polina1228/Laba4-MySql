package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteStudentController {

    @FXML
    private TextField idField;

    @FXML
    private Button Submit;

    @FXML
    private Button Cancel;

    @FXML
    void CancelClick() {
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SubmitClick() {
        int ID = Integer.parseInt(idField.getText());
        WorkWithServer.DeleteStudent(ID);

        CancelClick();


    }

}
