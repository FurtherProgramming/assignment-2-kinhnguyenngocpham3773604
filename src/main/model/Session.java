package main.model;

public class Session {

    private static String currentUser;

    public static String getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(String user) {
        currentUser = user;
    }
}
