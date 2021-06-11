package main.test;

import main.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    public Booking book = new Booking();

    @Test
    void getBookColor() {
        Assertions.assertEquals("-fx-background-color: GREEN", book.getBookColor("vacant"));
    }

    @Test
    void getBookState() throws SQLException {
        //depend on the database
        assertEquals("booked",book.getBookState(1));
    }
    @Test
    void toBooking() throws SQLException {
        //fail because there is no current user
        assertFalse(book.toBooking("20","12","2021","12"));
    }

    @Test
    void cancelBooking() throws SQLException {
        assertTrue(book.cancelBooking("admin"));
    }

    @Test
    void alreadyBooked() throws SQLException {
        assertFalse(book.alreadyBooked("admin"));
    }
}