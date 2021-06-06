package main.model;
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


}
