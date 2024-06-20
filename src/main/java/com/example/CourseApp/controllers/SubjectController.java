//package com.example.CourseApp.controllers;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//
//public class SubjectController {
//
//	@Autowired
//    private RestTemplate restTemplate;
//
//    // Endpoint to get usernames based on selected subjects
//    @GetMapping("/get-usernames")
//    public List<String> getUsernamesBySubjects(@RequestParam("subjects") String[] subjects) {
//        // URL of the C# API endpoint to get usernames based on subjects
//        String cSharpApiUrl = "http://csharp-api-hostname/api/get-usernames";
//        
//        // Make an HTTP request to the C# API
//        String[] usernames = restTemplate.postForObject(cSharpApiUrl, subjects, String[].class);
//        
//        // Return the list of usernames
//        return Arrays.asList(usernames);
//    }
//}


package com.example.CourseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class SubjectController {

    @Autowired
    private RestTemplate restTemplate;

    // Endpoint to get usernames based on selected categories
    @GetMapping("/get-usernames")
    public ResponseEntity<List<String>> getUsernamesByCategories(@RequestParam("categories") String categories) {
        // URL of the C# API endpoint to get usernames based on subjects
        String cSharpApiUrl = "https://localhost:44382/api/GetUsernamesBySubjects" + categories;

        // Make an HTTP GET request to the C# API
        String[] usernames = restTemplate.getForObject(cSharpApiUrl, String[].class);

        // Check if usernames are retrieved successfully
        if (usernames != null) {
            // Return the list of usernames
            return new ResponseEntity<>(List.of(usernames), HttpStatus.OK);
        } else {
            // If usernames are not retrieved, return an error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
// not use
