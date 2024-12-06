package org.example;

public interface UserService2 {
    boolean usernameExists(String username);
    boolean saveUser(String username, String password);
}
