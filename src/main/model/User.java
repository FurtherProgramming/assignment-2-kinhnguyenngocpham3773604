package main.model;
import javafx.fxml.FXML;
import main.SQLConnection;

import java.sql.*;

public class User {
    Connection connection;
    private String username="";

    public User(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserName(){
        return username;
    }

    public Boolean findUserName(String user) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public Boolean passwordConfirmation(String password, String confirmation){
        if(password.equals(confirmation) ){
            return true;
        }else{
            return false;
        }
    }

    public Boolean answerConfirmation(String question, String answer)throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where question = ? and answer= ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }


        public Boolean resetPassword(String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE employee SET password='" + password +"' WHERE username='" + getUserName() + "';");
        ResultSet resultSet=null;
        String query =  "select * from employee where password = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public String getUserRole(String user) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT role FROM employee where username='"+user+"';");
        String role = "";
        while (rs.next()) {
            role =rs.getString(1);
        }
        return role;
    }

    //fail to update error
    public Boolean updateAccount(String user, String pass, String question, String answer, String role, String fname, String lname) throws SQLException {
        PreparedStatement preparedStatement = null;
        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE employee SET password='"+pass +"' WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET question ='"+question +"' WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET answer ='"+answer +" 'WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET role ='"+role +" 'WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET first_name ='"+fname +"' WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET last_name ='"+lname +" 'WHERE username ='" +user+"';");
        stmt.execute("UPDATE employee SET username ='"+user+"' WHERE username ='" +user+"';");
        ResultSet resultSet=null;
        String query =  "select * from employee where username = ? and password= ? and question = ?" +
                "and answer=? and role = ? and first_name=? and last_name=?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, question);
            preparedStatement.setString(4, answer);
            preparedStatement.setString(5, role);
            preparedStatement.setString(6, fname);
            preparedStatement.setString(7, lname);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    public Boolean deleteAccount(String user) throws SQLException {
        PreparedStatement preparedStatement = null;
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM employee WHERE username='" +user + "';");
        ResultSet resultSet=null;
        String query =  "select * from employee where password = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}
