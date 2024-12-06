package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserManagerTest {
//
//  Question 2 Number 1
//
    @Mock
    private UserService2 userService2;

    @InjectMocks
    private UserManager userManager;

    @Test
    void testRegisterUser_WhenUsernameExists() {
        String username = "existingUser";
        String password = "password123";

        when(userService2.usernameExists(username)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);

        assertFalse(result, "false");
        verify(userService2).usernameExists(username);
        verify(userService2, never()).saveUser(anyString(), anyString());
    }

    @Test
    void testRegisterUser_WhenUsernameDoesNotExist() {
        String username = "newUser";
        String password = "password123";

        when(userService2.usernameExists(username)).thenReturn(false);
        when(userService2.saveUser(username, password)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);

        assertTrue(result, "True");
        verify(userService2).usernameExists(username);
        verify(userService2).saveUser(username, password);
    }

    @Test
    void testRegisterUser_SaveUserFails() {
        String username = "newUser";
        String password = "password123";

        when(userService2.usernameExists(username)).thenReturn(false);
        when(userService2.saveUser(username, password)).thenReturn(false);

        boolean result = userManager.registerUser(username, password);

        assertFalse(result, "RegisterUser should return false");
        verify(userService2).usernameExists(username);
        verify(userService2).saveUser(username, password);
    }
}
