package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.model.Booking;
import main.model.Session;
import main.model.Time;

import java.sql.SQLException;

public class CancelAlertController {
    public Booking book = new Booking();
    public Time time = new Time();
    @FXML private Button closeButton;
    @FXML
    private Label label;

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void cancelBooking(ActionEvent event){

        try {
            if (time.checkTime(Session.getCurrentUser())){
                label.setText("ran out of time to cancel");
            }
            else if (book.cancelBooking(Session.getCurrentUser())){
                label.setText("cancel successfully");
            }else{
                label.setText("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
