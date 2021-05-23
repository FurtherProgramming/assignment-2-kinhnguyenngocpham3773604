package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.model.RegisterModel;
import main.model.User;

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
    private TextField txtQuestion;
    @FXML
    private TextField txtAnswer;


    public void Register(ActionEvent event) {
//(username,password,question,answer,role,first_name,last_name)
        try {
            registerModel.isRegister(txtUsername.getText(), txtPassword.getText(), txtQuestion.getText()
                    , txtAnswer.getText(), txtRole.getText(), txtFirstName.getText(), txtLastName.getText());
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
