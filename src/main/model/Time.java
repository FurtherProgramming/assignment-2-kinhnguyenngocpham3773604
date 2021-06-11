package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Time {
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

    private Time() {
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
