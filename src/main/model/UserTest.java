package main.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    public User user = new User();
    @Test
    void resetPassword() throws SQLException {
        assertTrue(user.resetPassword("2"));
    }
}