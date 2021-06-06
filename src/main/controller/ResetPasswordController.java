package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.model.User;

import java.sql.SQLException;

public class ResetPasswordController {
    public User user = new User();
    @FXML
    private Label confirmation;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPasswordConfirmation;

    public void ResetPassword(ActionEvent event){

        try {
            if (user.passwordConfirmation(txtPassword.getText(),txtPasswordConfirmation.getText())){

                if(user.resetPassword(txtPassword.getText())){
                    confirmation.setText("Change successfully");
                }else{
                    confirmation.setText("Failed");
                }
            }else{
                confirmation.setText("password is not the same");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
