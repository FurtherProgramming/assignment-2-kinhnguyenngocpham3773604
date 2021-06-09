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
import main.model.SecretQuestion;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class ResetPasswordController {
    public User user = new User();
    @FXML
    private Label confirmation;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPasswordConfirmation;
    @FXML
    private TextField txtAnswer;
    @FXML private Button cancel;
    @FXML private ComboBox<String> questionComboBox;

    @FXML public void initialize() {
        try {
            questionComboBox.setItems(SecretQuestion.getInstance().getComboxItems());
            questionComboBox.getSelectionModel().selectFirst();
        } catch (IOException e) {
            System.out.println("Cannot load data");
        }
    }

    public void ResetPassword(ActionEvent event){

        try {
            if (user.passwordConfirmation(txtPassword.getText(),txtPasswordConfirmation.getText())
            && user.answerConfirmation(questionComboBox.getValue(),txtAnswer.getText())){

                if(user.resetPassword(txtPassword.getText())){
                    confirmation.setText("Change successfully");
                }else{
                    confirmation.setText("Failed");
                }
            }else{
                confirmation.setText("password is not the same");
            }
        } catch (SQLException e) {
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
