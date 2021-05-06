//package main.controller;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Window;
//
//import javax.xml.ws.Action;
//
//import java.io.IOException;
//
//public class SampleScreenController {
//    @FXML private Button toScreenButton;
//
//    @FXML public void nextScreenHandler(ActionEvent event){
//        //from button get scence
//        Scene scene = toScreenButton.getScene();
//        // from scene get window
//        Window window = scene.getWindow();
//        //treat the window as the primary stage by doing type casting
//        Stage primaryStage = (Stage) window;
//
//        Parent root =null;
//        // load nextScence
//        try
//        {
//            root = FXMLLoader.LOAD(getClass().getResource(/view/screen.fxml))
//        }catch ((IOException e){
//            System.out.println("Problem when loading FXML file");
//        }
//        //create new scene to store newly loaded FXML file
//        Scene nextScene = new Scene(root,witdh, height);
//
//        // set the primary stage to next stage
//        primaryStage.setScene(nextScene);
//
//        //set stage to next scene
//        primaryStage.setTitle("nextScene");
//    }
//}
