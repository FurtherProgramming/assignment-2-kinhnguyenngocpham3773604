package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.LoginModel;
import main.model.Session;
import main.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    public User user = new User();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML private Button Login;
    @FXML private Button toRegister;
    @FXML private Button toFindAccount;

    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }
    /* login Action method
       check if user input is the same as database.
     */
    public void Login(ActionEvent event){

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())){
                Session.setCurrentUser(txtUsername.getText());
                isConnected.setText("Logged in successfully");
                //from button get scence
                Scene scene = Login.getScene();
                // from scene get window
                Window window = scene.getWindow();
                //treat the window as the primary stage by doing type casting
                Stage primaryStage = (Stage) window;

                Parent root =null;
                // load nextScence
                if(user.getUserRole(txtUsername.getText()).equals("employee")) {
                    try {
                        root = FXMLLoader.load(getClass().getResource("../view/home.fxml"));
                    } catch (IOException e) {
                        System.out.println("Problem when loading FXML file");
                    }
                }else{
                    try {
                        root = FXMLLoader.load(getClass().getResource("../view/admin.fxml"));
                    } catch (IOException e) {
                        System.out.println("Problem when loading FXML file");
                    }
                }
                //create new scene to store newly loaded FXML file
                Scene register = new Scene(root,379, 200);
                // set the primary stage to next stage
                primaryStage.setScene(register);

                //set stage to next scene
                primaryStage.setTitle("Home");
            }else{
                isConnected.setText("username and password is incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @FXML public void toRegisterHandler(ActionEvent event){
        //from button get scence
        Scene scene = toRegister.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root =null;
        // load nextScence
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root,372, 406);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }
    @FXML public void toFindAccountHandler(ActionEvent event){
        //from button get scence
        Scene scene = toFindAccount.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root =null;
        // load nextScence
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/searchAccount.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root,372, 200);
        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Find account form");
    }

}