package main.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user = new User();
    @Test
    void resetPassword() throws SQLException {
        assertTrue(user.resetPassword("2"));
    }
}