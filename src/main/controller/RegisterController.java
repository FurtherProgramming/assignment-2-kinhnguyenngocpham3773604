package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.model.RegisterModel;
import main.model.Role;
import main.model.SecretQuestion;
import main.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController {
    private RegisterModel registerModel = new RegisterModel();
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtRole;
    @FXML
    private TextField txtAnswer;
    @FXML private ComboBox<String> questionComboBox;
    @FXML private ComboBox<String> roleComboBox;

    @FXML public void initialize() {
        try {
            questionComboBox.setItems(SecretQuestion.getInstance().getComboxItems());
            questionComboBox.getSelectionModel().selectFirst();
            roleComboBox.setItems(Role.getInstance().getComboxItems());
            roleComboBox.getSelectionModel().selectFirst();
        } catch (IOException e) {
            System.out.println("Cannot load data");
        }
    }


    public void Register(ActionEvent event) {
//(username,password,question,answer,role,first_name,last_name)
        try {
            registerModel.isRegister(txtUsername.getText(), txtPassword.getText(), questionComboBox.getValue()
                    , txtAnswer.getText(),roleComboBox.getValue(), txtFirstName.getText(), txtLastName.getText());
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
