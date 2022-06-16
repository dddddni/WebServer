package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
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
	
	String token;
	String cookie;
	List<String> cs;
	
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
    
    @GetMapping("/sapselect")
    public String sapselect()
    {
    	try {
    		URL url = new URL("https://my342781.sapbydesign.com/sap/byd/odata/cust/v1/externalresttestodata/RestAPIPostRootCollection?$format=json");

    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Basic YWRtaW5fZGlidXM6V2VsY29tZTI=");
			conn.setRequestProperty("x-csrf-token", "fetch");
			conn.setRequestProperty("set-cookie", "fetch");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			Map<String, List<String>> map = conn.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			    if ("x-csrf-token".equals(entry.getKey())) {
			        token = entry.getValue().get(0);
			       }
			    if ("set-cookie".equals(entry.getKey())) {
			    	cookie = entry.getValue().get(0).split(";")[0];
			    }
			}
		
			// sapset();
			return br.readLine();
			
    	}
    	catch (Exception e) {
			return e.getMessage();
		}
    }
    
    @PostMapping("/sapset")
    public void sapset()
   	{
    	try 
    	{
			URL url = new URL("https://my342781.sapbydesign.com/sap/byd/odata/cust/v1/externalresttestodata/RestAPIPostRootCollection");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept","application/json");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			conn.setRequestProperty("x-csrf-token", token);
		    conn.setRequestProperty("Authorization", "Basic YWRtaW5fZGlidXM6V2VsY29tZTI=");
		    conn.setRequestProperty("Cookie", cookie);

			conn.setDoInput(true); // 서버에 전달할 값이 있다면 true
			conn.setDoOutput(true); // 서버에서 받을 값이 있다면 true
			
			// 보낼 데이터 생성
			JSONObject obj = new JSONObject();
			obj.put("ID", "테스트");
	
			// buffer로 데이터 전달
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			bw.write(obj.toString());
			bw.flush();
			bw.close();
	
			// buffer로 데이터 수신
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			//printing response
			System.out.println(response.toString());
    	}
    	catch (Exception e) 
    	{
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
   	} 

}
