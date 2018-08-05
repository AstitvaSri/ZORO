package com.rest.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astitva.rest.entity.*;


@RestController
@RequestMapping("/zoroapi")
public class DemoRestController {
	private List<Students> theStudents;
	
	@PostConstruct //To Load the data just once, not for every request
	public void loadDataInList() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Students("Astitva","Srivastava"));
		theStudents.add(new Students("Anuj","Mishra"));
		theStudents.add(new Students("Elon","Musk"));
	}
	
	@GetMapping("/students")
	public List<Students> getStudents() {
				
		return theStudents;
	}
	
	//*******************************SEND OTP**************************************
	
	///////////////////////////////////////////////////////////////////////
	@CrossOrigin("http://127.0.0.1:9999")
	@PostMapping("/test")
	public SendOtp testApi(@RequestBody ReadEmail user) {

		System.out.println("TEST");
		System.out.println(user.getFirstName()+" "+user.getLastName()+", "+user.getUsername()+", "+user.getPassword());
		System.out.println("TEST");
		SendOtp sendOtp=new SendOtp(user.getUsername(),"ABCD12",false);
		return sendOtp;
		
	}
	
	
	
	
	
	
}
