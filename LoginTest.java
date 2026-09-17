/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kgosi
 */
public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("neo_n"));
        assertFalse(login.checkUserName("kyle!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        String result = login.registerUser("neo_n", "Ch&&sec@ke99!", "+27838968976", "Neo", "Nkosi");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        login.registerUser("neo_n", "Ch&&sec@ke99!", "+27838968976", "Neo", "Nkosi");
        assertTrue(login.loginUser("neo_n", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("neo_n", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        login.registerUser("neo_n", "Ch&&sec@ke99!", "+27838968976", "Neo", "Nkosi");
        assertEquals("Welcome Neo, Nkosi it is great to see you.", login.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}