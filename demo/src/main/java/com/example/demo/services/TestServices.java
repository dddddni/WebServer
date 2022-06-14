package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;

@Service
public class TestServices {
	
	 @Autowired
	 private TestRepository testRepository;
		
	 public Test save(Test test) {
		 	testRepository.save(test);
	        return test;
	 }

	public List<Test> selectAll() {
		return testRepository.findAll();
	}
}
