package org.example;
public class UserManager {
    private final UserService2 userService2;

    public UserManager(UserService2 userService2) {
        this.userService2 = userService2;
    }

    public boolean registerUser(String username, String password) {
        if (userService2.usernameExists(username)) {
            return false;
        }
        return userService2.saveUser(username, password);
    }
}

