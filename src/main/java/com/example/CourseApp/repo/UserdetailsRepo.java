package com.example.CourseApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseApp.entity.UserDetails;

@Repository
public interface UserdetailsRepo extends JpaRepository<UserDetails, Integer>{
    Optional<UserDetails> findByUsernameAndPassword(String username, String password);

}
