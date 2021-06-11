package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.RegisterModel;
import main.model.Role;
import main.model.SecretQuestion;
import main.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController {
    private RegisterModel registerModel = new RegisterModel();
    private User user = new User();
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPasswordConfirmation;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtAnswer;
    @FXML private Button cancel;
    @FXML private ComboBox<String> questionComboBox;
    @FXML private ComboBox<String> roleComboBox;
    @FXML
    private Label isRegister;
    @FXML public void initialize() {
        try {
            questionComboBox.setItems(SecretQuestion.getInstance().getComboxItems());
            questionComboBox.getSelectionModel().selectFirst();
            roleComboBox.setItems(Role.getInstance().getComboxItems());
            roleComboBox.getSelectionModel().selectFirst();
        } catch (IOException e) {
            System.out.println("Cannot load data");
        }
    }


    public void Register(ActionEvent event) {
//(username,password,question,answer,role,first_name,last_name)
        try {
            if(!user.passwordConfirmation(txtPassword.getText(),txtPasswordConfirmation.getText())){
                  isRegister.setText("password not match");
            }else if(txtPassword.getText().equals("")||txtAnswer.getText().equals("")||txtFirstName.getText().equals("")||
            txtLastName.getText().equals("")||txtUsername.getText().equals(""))
            {
                isRegister.setText("You have to fill all of the information");
            }else{
                registerModel.isRegister(txtUsername.getText(), txtPassword.getText(), questionComboBox.getValue()
                        , txtAnswer.getText(),roleComboBox.getValue(), txtFirstName.getText(), txtLastName.getText());

            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backLoginHandler(ActionEvent event){
        //from button get scence
        Scene scene = cancel.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root =null;
        // load nextScence
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root,379, 200);
        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Login form");
    }
}
