package main.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void getBookColor() {
        assertEquals("-fx-background-color: GREEN",Booking.getBookColor("vacant"));
    }

    @Test
    void getBookState() throws SQLException {
        assertEquals("vacant",Booking.getBookState(1));
    }
}