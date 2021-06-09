package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.model.SecretQuestion;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class ResetPasswordController {
    public User user = new User();
    @FXML
    private Label confirmation;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPasswordConfirmation;
    @FXML
    private TextField txtAnswer;
    @FXML private ComboBox<String> questionComboBox;

    @FXML public void initialize() {
        try {
            questionComboBox.setItems(SecretQuestion.getInstance().getComboxItems());
            questionComboBox.getSelectionModel().selectFirst();
        } catch (IOException e) {
            System.out.println("Cannot load data");
        }
    }

    public void ResetPassword(ActionEvent event){

        try {
            if (user.passwordConfirmation(txtPassword.getText(),txtPasswordConfirmation.getText())
            && user.answerConfirmation(questionComboBox.getValue(),txtAnswer.getText())){

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
