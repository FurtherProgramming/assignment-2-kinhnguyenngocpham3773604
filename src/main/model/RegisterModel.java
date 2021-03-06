package main.model;

import main.SQLConnection;

import java.sql.*;

public class RegisterModel {
    Connection connection;
//    INSERT INTO employee (username,password,question,answer,role,first_name,last_name) VALUES ("test","test","what","me","employee","test","test");

    public RegisterModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }
    public void isRegister(String username, String password, String question, String answer, String role, String firstName, String lastName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Statement stmt =null;
        try {
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO employee (username,password,question,answer,role,first_name,last_name) " +
                    "values ('"+ username + "', '" + password +"', '" + question +"', '" + answer + "', '" + role + "', '" + firstName + "', '" + lastName + "');");
            System.out.println("INSERT INTO employee (username, password, email, country, gender, first_name, last_name,activation) values ('"+ username + "', '" + password + "', '" + question + "', '" + answer + "', '" + role + "', '" + firstName + "', '" + lastName + "')");

        }
        catch (SQLException e){
            e.printStackTrace();

        }
        stmt.close();
    }
}