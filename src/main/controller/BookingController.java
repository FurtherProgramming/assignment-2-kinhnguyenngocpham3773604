package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.model.Booking;
import main.model.SecretQuestion;
import main.model.Time;

import java.io.IOException;
import java.sql.SQLException;

public class BookingController {
    @FXML private Button table1;
    @FXML private Button table2;
    @FXML private Button table3;
    @FXML private Button table4;
    @FXML private Button table5;
    @FXML private Button table6;
    @FXML private Button table7;
    @FXML private Button table8;
    @FXML private Button table9;
    @FXML private Button table10;
    @FXML private Button table11;
    @FXML private Button table12;
    @FXML private Button table13;
    @FXML private Button table14;
    @FXML private Button table15;
    @FXML private Button table16;



    @FXML public void initialize() {
        int counter = 0;
        String color;
        String state;
        try {
            for(int i = 1;i<=16;i++){
                counter++;
                state = Booking.getBookState(i);
                color = Booking.getBookColor(state);
                if(counter==1) {
                    table1.setStyle(color);
                }
                else if(counter == 2){
                    table2.setStyle(color);
                }
                else if(counter == 3){
                    table3.setStyle(color);
                }
                else if(counter == 4){
                    table4.setStyle(color);
                }
                else if(counter == 5){
                    table5.setStyle(color);
                }
                else if(counter == 6){
                    table6.setStyle(color);
                }
                else if(counter == 7){
                    table7.setStyle(color);
                }
                else if(counter == 8){
                    table8.setStyle(color);
                }
                else if(counter == 9){
                    table9.setStyle(color);
                }
                else if(counter == 10){
                    table10.setStyle(color);
                }
                else if(counter == 11){
                    table11.setStyle(color);
                }
                else if(counter == 12){
                    table12.setStyle(color);
                }
                else if(counter == 13){
                    table13.setStyle(color);
                }
                else if(counter == 14){
                    table14.setStyle(color);
                }
                else if(counter == 15){
                    table15.setStyle(color);
                }
                else if(counter == 16){
                    table16.setStyle(color);
                }

            }
        } catch (SQLException e) {
            e.getStackTrace();
        }


    }
    @FXML
    public void table1Handler(ActionEvent event){
        Booking.setTableID(1);
        Parent root =null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/bookTable.fxml"));
        }catch (IOException e){
            System.out.println("Problem when loading FXML file");
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Booking form");
        stage.show();
    }
}
