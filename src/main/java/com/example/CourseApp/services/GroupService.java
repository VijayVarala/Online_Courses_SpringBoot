package com.example.CourseApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseApp.entity.Groups;
import com.example.CourseApp.repo.GroupRepo;

@Service

public class GroupService {
	  @Autowired
	    private GroupRepo groupRepository;

	    public List<Groups> getAllGroups() {
	        return groupRepository.findAll();
	    }

	    public Optional<Groups> getGroupById(Long id) {
	        return groupRepository.findById(id);
	    }

	    public Groups createGroup(Groups group) {
	        return groupRepository.save(group);
	    }
}
