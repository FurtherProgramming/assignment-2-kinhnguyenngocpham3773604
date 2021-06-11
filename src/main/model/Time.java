package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Time {
    Connection connection;
    private static Time time;
    private String message;

    private List<String> dates= Arrays.asList("date","01","02","03"
            , "04","05","06","07","08","09","10","11","12","13","14","15","16","17",
            "18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    private List<String> months= Arrays.asList("month","01","02","03"
            , "04","05","06","07","08","09","10","11","12");
    private List<String> years= Arrays.asList("year","2021","2022","2023"
            , "2024");
    private List<String> hours= Arrays.asList("hours","01","02","03"
            , "04","05","06","07","08","09","10","11","12","13","14","15","16","17",
            "18","19","20","21","22","23","24");

    public Time() {
    }
    public static Time getInstance() {
        if (time == null) {
            time = new Time();
        }

        return time;
    }
    public List<String> getDates() {
        return dates;
    }

    public ObservableList<String> getComboxDates() throws IOException {
        return FXCollections.observableList(getDates());
    }

    public List<String> getMonths() {
        return months;
    }

    public ObservableList<String> getComboxMonths() throws IOException {
        return FXCollections.observableList(getMonths());
    }

    public List<String> getYears() {
        return years;
    }

    public ObservableList<String> getComboxYears() throws IOException {
        return FXCollections.observableList(getYears());
    }

    public List<String> getHours() {
        return hours;
    }

    public ObservableList<String> getComboxHours() throws IOException {
        return FXCollections.observableList(getHours());
    }

    public Boolean checkTime(String user) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTimeA = LocalDateTime.of(getUserYear(user), getUserMonth(user), getUserDate(user), getUserHour(user), 0, 0, 0);
        long hours = ChronoUnit.HOURS.between(dateTimeA, now);
        if(hours<48)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public int getUserDate(String user) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT date FROM book where username='"+user+"';");
        String result = "";
        while (rs.next()) {
            result =rs.getString(1);
        }
        int date = Integer.parseInt(result);
        return date;
    }
    public int getUserMonth(String user) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT month FROM book where username='"+user+"';");
        String result = "";
        while (rs.next()) {
            result =rs.getString(1);
        }
        int month = Integer.parseInt(result);
        return month;
    }
    public int getUserYear(String user) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT year FROM book where username='"+user+"';");
        String result = "";
        while (rs.next()) {
            result =rs.getString(1);
        }
        int year = Integer.parseInt(result);
        return year;
    }
    public int getUserHour(String user) throws SQLException {
        connection = SQLConnection.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT hour FROM book where username='"+user+"';");
        String result = "";
        while (rs.next()) {
            result =rs.getString(1);
        }
        int hour = Integer.parseInt(result);
        return hour;
    }
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
