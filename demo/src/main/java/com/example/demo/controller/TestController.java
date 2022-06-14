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
	// 데이터 생성
	public String Post()
	{
		return "Post 입니다";
	}
	
	@GetMapping("/test")
	// 데이터 조회
	public String Get()
	{
		return "Get 입니다";
	}
	
	@PutMapping("/test")
	// 데이터 수정
	public String Put()
	{
		return "Put 입니다";
	}
	
	@DeleteMapping("/test")
	// 데이터 삭제
	public String Delete()
	{
		return "Delete 입니다";
	}

	@Autowired
	TestServices testServices;

    // 회원 입력
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
	 * requestData){ // get과 다르게 객체를 사용하여 받아와도 RequestBody를 입력해줘야한다.
	 * 
	 * System.out.println(requestData); return new
	 * ResponseEntity<Test>(testServices.save(requestData), HttpStatus.OK); }
	 */
    
    
    
}
