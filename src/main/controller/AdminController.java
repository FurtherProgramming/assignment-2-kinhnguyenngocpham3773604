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
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class AdminController {
    private User user = new User();
    @FXML
    private Label alert;
    @FXML
    private Button toRegister;
    @FXML
    private Button toDeleteAccount;
    @FXML
    private Button toUpdateAccount;
    @FXML
    private Button toBook;
    @FXML
    private Button cancelBook;
    @FXML
    private Button logout;
    @FXML
    private Button backHome;
    @FXML
    private TextField txtUsername;
    @FXML
    public void toBookHandler(ActionEvent event) {
        //from button get scence
        Scene scene = toBook.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root = null;
        // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/booking.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root, 600, 554);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }

    @FXML
    public void Logout(ActionEvent event) {
        //from button get scence
        Scene scene = logout.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root = null;
        // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root, 379, 200);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Login form");
    }

    @FXML
    public void cancelBoolHandler(ActionEvent event) throws SQLException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/cancelalert.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Cancel Alert");
        stage.show();
    }

    @FXML
    public void profileHandler(ActionEvent event) throws SQLException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/Profile.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Profile");
        stage.show();
    }

    @FXML
    public void toRegisterHandler(ActionEvent event) {
        //from button get scence
        Scene scene = toRegister.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root = null;
        // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root, 372, 406);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }

    @FXML
    public void toDeleteAccountHandler(ActionEvent event) {
        //from button get scence
        Scene scene = toDeleteAccount.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root = null;
        // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/adminDeleteAccount.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root, 228, 146);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }

    @FXML
    public void toUpdateaccountHandler(ActionEvent event) {
        //from button get scence
        Scene scene = toUpdateAccount.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root = null;
        // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/adminUpdateAccount.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root, 372, 406);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }

    @FXML
    public void backHomeHandler(ActionEvent event) {
    Scene scene = backHome.getScene();
    // from scene get window
    Window window = scene.getWindow();
    //treat the window as the primary stage by doing type casting
    Stage primaryStage = (Stage) window;

    Parent root = null;
    // load nextScence
        try {
            root = FXMLLoader.load(getClass().getResource("../view/admin.fxml"));
        } catch (IOException e) {
            System.out.println("Problem when loading FXML file");
        }


    //create new scene to store newly loaded FXML file
    Scene register = new Scene(root, 379, 200);
    // set the primary stage to next stage
                primaryStage.setScene(register);

    //set stage to next scene
                primaryStage.setTitle("Home");
    }

    public void deleteAccount(ActionEvent event) {
        try {
            if(!user.deleteAccount(txtUsername.getText())){
                alert.setText("delete success");
            }
            else{
                alert.setText("delete fail");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
