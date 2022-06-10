package com.example.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@RequestMapping("/test")
	public String Test()
	{
		return "Test ¿‘¥œ¥Ÿ";
	}

}
