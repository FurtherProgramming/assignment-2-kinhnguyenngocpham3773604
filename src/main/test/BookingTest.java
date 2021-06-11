package main.test;

import main.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void getBookColor() {
        Assertions.assertEquals("-fx-background-color: GREEN", Booking.getBookColor("vacant"));
    }

    @Test
    void getBookState() throws SQLException {
        assertEquals("vacant",Booking.getBookState(1));
    }
    @Test
    void booking() {
    }

    @Test
    void cancelBooking() {
    }

    @Test
    void alreadyBooked() {
    }
}