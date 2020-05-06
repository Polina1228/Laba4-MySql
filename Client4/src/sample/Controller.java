package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Model.Student;

import java.io.IOException;

public class Controller {

    @FXML
    TableView<Student> tableStudent;

    @FXML
    TableColumn<Student, Integer> tId;

    @FXML
    TableColumn<Student,String> tSurname;

    @FXML
    TableColumn<Student,String> tName;

    @FXML
    TableColumn<Student,String> tMiddleName;

    @FXML
    TableColumn<Student,Integer> tAge;

    @FXML
    TableColumn<Student,String> tAverageGrade;

    @FXML
    private Button Add;

    @FXML
    private Button Update;

    @FXML
    private Button UpdateWindow;

    @FXML
    private Button Delete;

    @FXML
    private Button Close;

    @FXML
    private Tab tab;

    @FXML
    private void initialize(){
        ObservableList<Student> data = FXCollections.observableArrayList();
        tab();
        tableStudent.setItems(WorkWithServer.DBTableStudent());
    }

    private void tab(){
        tId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Id"));
        tSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("Surname"));
        tName.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        tMiddleName.setCellValueFactory(new PropertyValueFactory<Student, String>("MiddleName"));
        tAge.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Age"));
        tAverageGrade.setCellValueFactory(new PropertyValueFactory<Student, String>("AverageGrade"));
    }

    @FXML
    private void AddStudent()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddStudent.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    private void DeleteStudent()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeleteStudent.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    private void UpdateStudent()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdateStudent.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    private void CloseWindow()
    {
        Stage stage1 = (Stage) UpdateWindow.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void UpdateWindow()
    {
        Stage stage1 = (Stage) UpdateWindow.getScene().getWindow();
        stage1.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
