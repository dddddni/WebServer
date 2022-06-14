package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Test;
import com.example.demo.services.TestServices;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@PostMapping("/test")
	// ������ ����
	public String Post()
	{
		return "Post �Դϴ�";
	}
	
	@GetMapping("/test")
	// ������ ��ȸ
	public String Get()
	{
		return "Get �Դϴ�";
	}
	
	@PutMapping("/test")
	// ������ ����
	public String Put()
	{
		return "Put �Դϴ�";
	}
	
	@DeleteMapping("/test")
	// ������ ����
	public String Delete()
	{
		return "Delete �Դϴ�";
	}

	@Autowired
	TestServices testServices;

    // ȸ�� �Է�
//    @PostMapping("/save")
//    public ResponseEntity <Test> save(@RequestBody Test member) {
//        return new ResponseEntity<Test>(testServices.save(member), HttpStatus.OK);
//    }
    
    @PostMapping("/save")
    public Test save(@RequestBody Test test){
    	new ResponseEntity<Test>(testServices.save(test), HttpStatus.OK);
    	return test;
    }

    @GetMapping("/select")
    public List<Test> tests() {
    	System.out.println(testServices.selectAll().toString());
        return testServices.selectAll();
    }
    
    
	/*
	 * @PostMapping("/save") public ResponseEntity <Test> save(@RequestBody Test
	 * requestData){ // get�� �ٸ��� ��ü�� ����Ͽ� �޾ƿ͵� RequestBody�� �Է�������Ѵ�.
	 * 
	 * System.out.println(requestData); return new
	 * ResponseEntity<Test>(testServices.save(requestData), HttpStatus.OK); }
	 */
    
    
    
}
