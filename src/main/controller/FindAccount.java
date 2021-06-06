package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.LoginModel;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class FindAccount {
    public User user = new User();
    @FXML
    private Label notify;
    @FXML
    private TextField txtUsername;
    @FXML private Button backLogin;
    @FXML private Button toResetPassword;
    @FXML
    public void backLoginHandler(ActionEvent event){
        //from button get scence
        Scene scene = backLogin.getScene();
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

    @FXML
    public void toResetPasswordHandler(ActionEvent event){
        try {
            if (user.findUserName(txtUsername.getText())){
                user.setUsername(txtUsername.getText());
                //from button get scence
                Scene scene = toResetPassword.getScene();
                // from scene get window
                Window window = scene.getWindow();
                //treat the window as the primary stage by doing type casting
                Stage primaryStage = (Stage) window;

                Parent root =null;
                // load nextScence
                try
                {
                    root = FXMLLoader.load(getClass().getResource("../view/resetPassword.fxml"));
                }catch (IOException e){
                    System.out.println("Problem when loading FXML file");
                }
                //create new scene to store newly loaded FXML file
                Scene register = new Scene(root,379, 200);
                // set the primary stage to next stage
                primaryStage.setScene(register);

                //set stage to next scene
                primaryStage.setTitle("Reset password form");
            }else{
                notify.setText("Cannot find an account");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
