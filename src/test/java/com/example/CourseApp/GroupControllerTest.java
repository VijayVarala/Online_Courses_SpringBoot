package com.example.CourseApp;
//
//public class GroupControllerTest {
//
//}


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.CourseApp.controllers.GroupController;
import com.example.CourseApp.entity.Groups;
import com.example.CourseApp.services.GroupService;

@ExtendWith(MockitoExtension.class)
public class GroupControllerTest {

    @Mock
    private GroupService groupService;

    @InjectMocks
    private GroupController groupController;

    @Test
    public void testGetAllGroups() {
        // Prepare mock data
        List<Groups> mockGroups = new ArrayList<>();
        mockGroups.add(new Groups(1L, "Group 1", "Description 1", "Location 1", true, false, "Subjects 1", "User 1"));
        mockGroups.add(new Groups(2L, "Group 2", "Description 2", "Location 2", false, true, "Subjects 2", "User 2"));

        // Mock behavior
        when(groupService.getAllGroups()).thenReturn(mockGroups);

        // Perform the test
        ResponseEntity<List<Groups>> response = groupController.getAllGroups();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockGroups, response.getBody());
    }

    @Test
    public void testGetGroupById() {
        // Prepare mock data
        Groups mockGroup = new Groups(1L, "Group 1", "Description 1", "Location 1", true, false, "Subjects 1", "User 1");

        // Mock behavior
        when(groupService.getGroupById(1L)).thenReturn(Optional.of(mockGroup));

        // Perform the test
        ResponseEntity<Groups> response = groupController.getGroupById(1L);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockGroup, response.getBody());
    }

    @Test
    public void testGetGroupById_NotFound() {
        // Mock behavior
        when(groupService.getGroupById(1L)).thenReturn(Optional.empty());

        // Perform the test
        ResponseEntity<Groups> response = groupController.getGroupById(1L);

        // Assertions
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertTrue(response.getBody().isEmpty()); // Assert body is empty

    }

    @Test
    public void testCreateGroup() {
        // Prepare mock data
        Groups newGroup = new Groups(null, "New Group", "New Description", "New Location", true, false, "New Subjects", "New User");
        Groups savedGroup = new Groups(1L, "New Group", "New Description", "New Location", true, false, "New Subjects", "New User");

        // Mock behavior
        when(groupService.createGroup(newGroup)).thenReturn(savedGroup);

        // Perform the test
        ResponseEntity<Groups> response = groupController.createGroup(newGroup);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedGroup, response.getBody());
    }
}
