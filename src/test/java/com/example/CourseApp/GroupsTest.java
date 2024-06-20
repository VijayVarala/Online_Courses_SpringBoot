package com.example.CourseApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.CourseApp.entity.Groups;

public class GroupsTest {

	@Test
    public void testConstructorAndGetters() {
        // Create a Groups object with sample data
        Long id = 1L;
        String name = "Group 1";
        String description = "Description 1";
        String location = "Location 1";
        boolean publicGroup = true;
        boolean approvalRequired = false;
        String subjects = "Subjects 1";
        String username = "User 1";

        Groups group = new Groups(id, name, description, location, publicGroup, approvalRequired, subjects, username);

        // Test getters
        assertEquals(id, group.getId());
        assertEquals(name, group.getName());
        assertEquals(description, group.getDescription());
        assertEquals(location, group.getLocation());
        assertEquals(publicGroup, group.isPublicGroup());
        assertEquals(approvalRequired, group.isApprovalRequired());
        assertEquals(subjects, group.getSubjects());
        assertEquals(username, group.getUsername());
    }

    @Test
    public void testSetters() {
        // Create a Groups object
        Groups group = new Groups();

        // Set sample data using setters
        Long id = 2L;
        String name = "Group 2";
        String description = "Description 2";
        String location = "Location 2";
        boolean publicGroup = false;
        boolean approvalRequired = true;
        String subjects = "Subjects 2";
        String username = "User 2";

        group.setId(id);
        group.setName(name);
        group.setDescription(description);
        group.setLocation(location);
        group.setPublicGroup(publicGroup);
        group.setApprovalRequired(approvalRequired);
        group.setSubjects(subjects);
        group.setUsername(username);

        // Test getters
        assertEquals(id, group.getId());
        assertEquals(name, group.getName());
        assertEquals(description, group.getDescription());
        assertEquals(location, group.getLocation());
        assertEquals(publicGroup, group.isPublicGroup());
        assertEquals(approvalRequired, group.isApprovalRequired());
        assertEquals(subjects, group.getSubjects());
        assertEquals(username, group.getUsername());
    }
}
