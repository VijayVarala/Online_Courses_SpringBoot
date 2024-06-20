package com.example.CourseApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.CourseApp.controllers.UserdetailsCnotroller;
import com.example.CourseApp.entity.UserDetails;
import com.example.CourseApp.services.UserdetailsServices;

@ExtendWith(MockitoExtension.class)
public class UserdetailsControllerTest {

    @Mock
    private UserdetailsServices userdetailsServicesMock;

    @InjectMocks
    private UserdetailsCnotroller userdetailsController;

    private List<UserDetails> mockUsersList;

    @BeforeEach
    void setUp() {
        mockUsersList = new ArrayList<>();
        UserDetails user1 = new UserDetails(2, "User2", "LastName2", "user2@example.com", "password2", "02-02-1991", "Location2", "Female", "username2", new byte[0], new String[0], new String[0]);
        UserDetails user2 = new UserDetails(2, "User2", "LastName2", "user2@example.com", "password2", "02-02-1991", "Location2", "Female", "username2", new byte[0], new String[0], new String[0]);
        mockUsersList.add(user1);
        mockUsersList.add(user2);
    }

    @Test
    void testGetAllUsers_Success() {
        when(userdetailsServicesMock.getAllUsers()).thenReturn(mockUsersList);

        ResponseEntity<List<UserDetails>> response = userdetailsController.getAllUsers();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsersList, response.getBody());
    }

    @Test
    void testCreateUser_Success() {
        UserDetails newUser = new UserDetails(2, "User2", "LastName2", "user2@example.com", "password2", "02-02-1991", "Location2", "Female", "username2", new byte[0], new String[0], new String[0]);
        when(userdetailsServicesMock.createUser(any(UserDetails.class))).thenReturn(newUser);

        ResponseEntity<UserDetails> response = userdetailsController.createUser(newUser);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newUser, response.getBody());
    }

    @Test
    void testGetUserById_Success() {
        int userId = 1;
        UserDetails user = new UserDetails(2, "User2", "LastName2", "user2@example.com", "password2", "02-02-1991", "Location2", "Female", "username2", new byte[0], new String[0], new String[0]);
        when(userdetailsServicesMock.getUserById(userId)).thenReturn(Optional.of(user));

        ResponseEntity<UserDetails> response = userdetailsController.getUserById(userId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetUserById_NotFound() {
        int nonExistentUserId = 100;
        when(userdetailsServicesMock.getUserById(nonExistentUserId)).thenReturn(Optional.empty());

        ResponseEntity<UserDetails> response = userdetailsController.getUserById(nonExistentUserId);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
