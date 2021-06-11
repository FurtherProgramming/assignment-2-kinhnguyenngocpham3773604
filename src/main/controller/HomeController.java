package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.Booking;

import java.io.IOException;
import java.sql.SQLException;

public class HomeController {
    @FXML private Button toBook;
    @FXML private Button cancelBook;
    @FXML private Button profile;
    @FXML private Button logout;

    @FXML
    public void toBookHandler(ActionEvent event){
        //from button get scence
        Scene scene = toBook.getScene();
        // from scene get window
        Window window = scene.getWindow();
        //treat the window as the primary stage by doing type casting
        Stage primaryStage = (Stage) window;

        Parent root =null;
        // load nextScence
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/booking.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        //create new scene to store newly loaded FXML file
        Scene register = new Scene(root,600, 554);

        // set the primary stage to next stage
        primaryStage.setScene(register);

        //set stage to next scene
        primaryStage.setTitle("Register form");
    }

    @FXML
    public void Logout(ActionEvent event){
        //from button get scence
        Scene scene = logout.getScene();
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
    public void cancelBoolHandler(ActionEvent event) throws SQLException {

                Parent root =null;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("../view/cancelalert.fxml"));
                }catch (IOException e){
                    System.out.println("Problem when loading FXML file");
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Cancel Alert");
                stage.show();
            }

    @FXML
    public void profileHandler(ActionEvent event) throws SQLException {

        Parent root =null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/Profile.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Profile");
        stage.show();
    }
}
