package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.model.Session;

public class ProfileController {
    @FXML
    private Label username;

    @FXML
    public void initialize() {
        username.setText(Session.getCurrentUser());
    }
}
