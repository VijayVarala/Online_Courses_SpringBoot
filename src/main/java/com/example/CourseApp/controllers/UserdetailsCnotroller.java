package com.example.CourseApp.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseApp.entity.UserDetails;
import com.example.CourseApp.services.UserdetailsServices;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserdetailsCnotroller {
    @Autowired
    private UserdetailsServices userdetailsServices;

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> users = userdetailsServices.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
        UserDetails newUser = userdetailsServices.createUser(userDetails);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable("id") Integer id) {
        Optional<UserDetails> userOptional = userdetailsServices.getUserById(id);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/usernamesBySubject/{subject}")
    public ResponseEntity<List<String>> getUsernamesBySelectedSubject(@PathVariable("subject") String subject) {
        List<String> usernames = userdetailsServices.getUsernamesBySelectedSubject(subject);
        return new ResponseEntity<>(usernames, HttpStatus.OK);
    }
    
    public class Response {
        private boolean success;
        private UserDetails data;

        // Constructor
        public Response(boolean success, UserDetails data) {
            this.success = success;
            this.data = data;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public UserDetails getData() {
            return data;
        }

        public void setData(UserDetails data) {
            this.data = data;
        }
    }


    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<?>> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        
        try {
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Username and password are required."));
            }

            return userdetailsServices.login(username, password).thenApply(userDetails -> {
                if (userDetails.isPresent()) {
                    return ResponseEntity.ok(new Response(true, userDetails.get()));
                } else {
                    return ResponseEntity.status(401).build();
                }
            });
        } catch (Exception ex) {
            return CompletableFuture.completedFuture(ResponseEntity.status(500).body("An error occurred: " + ex.getMessage()));
        }
    }

}
