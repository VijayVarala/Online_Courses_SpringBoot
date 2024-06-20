package com.example.CourseApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CourseApp.entity.Groups;

@Repository
public interface GroupRepo extends JpaRepository<Groups, Long>{

}
