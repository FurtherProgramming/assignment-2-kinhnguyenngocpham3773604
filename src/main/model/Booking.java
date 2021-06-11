package main.model;

import main.SQLConnection;

import java.sql.*;
import java.util.LinkedList;

public class Booking {
    private static Connection connection;
    private static int tableID = 0;


    public Booking(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public static String getBookColor(String state) {
        if(state.equals("vacant")){
            return "-fx-background-color: GREEN";
        }
        else if (state.equals("booked")){
            return "-fx-background-color: RED";
        }
        else{
            return "-fx-background-color: ORANGE";
        }
    }

    public static String getBookState(int i) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT state FROM book where id="+i+";");
        String state = "";
        while (rs.next()) {
            state =rs.getString(1);
        }
        return state;
    }

    public static void setTableID(int id) {
        tableID=id;
    }

    public Boolean booking(String date,String month, String year,String hour) throws SQLException {
        PreparedStatement preparedStatement = null;
        Statement stmt = connection.createStatement();
        int intDate= Integer.parseInt(date);
        int intMonth= Integer.parseInt(month);
        int intYear = Integer.parseInt(year);
        int intHour= Integer.parseInt(hour);
        String updateState = "booked";
        stmt.execute("UPDATE book SET state='"+updateState +"' WHERE id =" +tableID+";");
        stmt.execute(" UPDATE book SET date ="+intDate +" WHERE id =" +tableID+";");
        stmt.execute(" UPDATE book SET month ="+intMonth +" WHERE id =" +tableID+";");
        stmt.execute(" UPDATE book SET year ="+intYear +" WHERE id =" +tableID+";");
        stmt.execute(" UPDATE book SET hour ="+intHour +" WHERE id =" +tableID+";");
        stmt.execute(" UPDATE book SET username ='"+Session.getCurrentUser() +"' WHERE id =" +tableID+";");
        ResultSet resultSet=null;
        String query =  "select * from book where state = ? and username= ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateState);
            preparedStatement.setString(2, Session.getCurrentUser());
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

    public boolean cancelBooking(String user) throws SQLException {
        PreparedStatement preparedStatement = null;
        Statement stmt = connection.createStatement();
        String updateState = "vacant";
        stmt.execute("UPDATE book SET state='"+updateState +"' WHERE username ='" +user+"';");
        stmt.execute(" UPDATE book SET date ="+0 +" WHERE username ='" +user+"';");
        stmt.execute(" UPDATE book SET month ="+0 +" WHERE username ='" +user+"';");
        stmt.execute(" UPDATE book SET year ="+0 +" WHERE username ='" +user+"';");
        stmt.execute(" UPDATE book SET hour ="+0 +" WHERE username ='" +user+"';");
        stmt.execute(" UPDATE book SET username ='"+""+"' WHERE username ='" +user+"';");
        ResultSet resultSet=null;
        String query =  "select * from book where state = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateState);
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

    public Boolean alreadyBooked(String user) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from book where username = ?";
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
