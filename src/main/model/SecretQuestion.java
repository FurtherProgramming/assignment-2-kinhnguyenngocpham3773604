package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecretQuestion {
    private static SecretQuestion secretQuestion;
    private String message;



    private List<String> questions= Arrays.asList("Please select a question","What is your mother's maiden name?"
            , "What was your first pet?", "What was the model of your first car?"
            , "In what city were you born?","What was your father's middle name?","What was your childhood nickname?");

    private SecretQuestion() {
    }
    public List<String> getQuestions() {
        return questions;
    }
    public static SecretQuestion getInstance() {
        if (secretQuestion == null) {
            secretQuestion = new SecretQuestion();
        }

        return secretQuestion;
    }

    public ObservableList<String> getComboxItems() throws IOException {
        return FXCollections.observableList(getQuestions());
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
