package com.example.CourseApp.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CourseApp.entity.UserDetails;
import com.example.CourseApp.repo.UserdetailsRepo;
import java.util.concurrent.CompletableFuture;

@Service
public class UserdetailsServices {
    @Autowired
    private UserdetailsRepo userdetailsRepo;

    public List<UserDetails> getAllUsers() {
        return userdetailsRepo.findAll();
    }

    public UserDetails createUser(UserDetails userDetails) {
        return userdetailsRepo.save(userDetails);
    }

    public Optional<UserDetails> getUserById(Integer id) {
        return userdetailsRepo.findById(id);
    }

    public List<String> getUsernamesBySelectedSubject(String subject) {
        return userdetailsRepo.findAll().stream()
                .filter(user -> user.getSelectedSubjects() != null && Arrays.asList(user.getSelectedSubjects()).contains(subject))
                .map(UserDetails::getUsername)
                .collect(Collectors.toList());
    }
    public CompletableFuture<Optional<UserDetails>> login(String username, String password) {
        return CompletableFuture.supplyAsync(() -> userdetailsRepo.findByUsernameAndPassword(username, password));
    }
}
