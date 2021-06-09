package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Role {
    private static Role role;
    private String message;



    private List<String> roles= Arrays.asList("Employee"
            , "Admin");

    private Role() {
    }
    public List<String> getRoles() {
        return roles;
    }
    public static Role getInstance() {
        if (role == null) {
            role = new Role();
        }

        return role;
    }

    public ObservableList<String> getComboxItems() throws IOException {
        return FXCollections.observableList(getRoles());
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
