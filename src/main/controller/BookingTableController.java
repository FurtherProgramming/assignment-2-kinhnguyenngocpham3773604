package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import main.model.Booking;
import main.model.Time;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class BookingTableController {
    public Booking book = new Booking();
    @FXML
    private ComboBox<String> dateComboBox;
    @FXML private ComboBox<String> monthComboBox;
    @FXML private ComboBox<String> yearComboBox;
    @FXML private ComboBox<String> hourComboBox;
    @FXML
    private Label label;

    @FXML public void initialize() {
        try {
            dateComboBox.setItems(Time.getInstance().getComboxDates());
            dateComboBox.getSelectionModel().selectFirst();
            yearComboBox.setItems(Time.getInstance().getComboxYears());
            yearComboBox.getSelectionModel().selectFirst();
            monthComboBox.setItems(Time.getInstance().getComboxMonths());
            monthComboBox.getSelectionModel().selectFirst();
            hourComboBox.setItems(Time.getInstance().getComboxHours());
            hourComboBox.getSelectionModel().selectFirst();
        } catch (IOException e) {
            System.out.println("Cannot load data");
        }
    }

    public void Booking(ActionEvent event){

        try {
            if (book.booking(dateComboBox.getValue(),monthComboBox.getValue()
            ,yearComboBox.getValue(),hourComboBox.getValue())){
                label.setText("successfully");
            }else{
                label.setText("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
