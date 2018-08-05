package com.rest.controller;


import java.io.IOException;
import java.util.List;
import org.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.cfg.Configuration;

import com.astitva.rest.entity.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin("http://127.0.0.1:9999")
@RequestMapping("/zoroapi")
public class DemoRestController {
	public static SessionFactory factory; //Necessary for all the API requests to communicate with HIBERNATE
	public String receivedOTP; //for lambda expression (email otp and save to db)
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//CHECKING EXISTING EMAIL AND SENDING OTP IF EMAIL NOT EXISTS, ALSO SAVEING OTP TO DATABASE
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/checkexistence/{newEmail}")
	public Existence checkNewEmail(@PathVariable String newEmail) {
					boolean exist=false;
					
					List<UserPersonalDetails> usersList;
					 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserPersonalDetails.class).buildSessionFactory();

						System.out.println("Factory created");
					Session session=factory.openSession();
					System.out.println("Session Opened");
				
				try {
					session.beginTransaction();
					usersList=session.createQuery("from UserPersonalDetails u where u.email='"+newEmail+"'").getResultList(); //Write Class Name and Property name in query
					exist=(!usersList.isEmpty());
					session.getTransaction().commit();
				}
				finally {
					factory.close();
				}
				
				System.out.println("EXIST:"+exist);
				Existence responseJSON=new Existence(newEmail,exist);
				
				

				//email otp and save to db thread	
				
				
				if(!exist) {
					
					new Thread(()->{				
						MailOtp mailObj = new MailOtp();
						receivedOTP=mailObj.mailOtpNow(newEmail);	
						OtpDbEntry otpDb = new OtpDbEntry();
						otpDb.saveOtp(newEmail, receivedOTP);
				
					}).start();
				}			
				
		return responseJSON;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//GETTING DETAILS FROM USER AND SAVING TO DATABASE
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/savedetails")
	public RegistrationResponse saveUserDetails(@RequestBody DetailsJson detailsJson) throws JsonParseException, JsonMappingException, IOException {		
		
		String email;
		String responseEmail;
		
		
		System.out.println("Starting to read hibernate config...");
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserPersonalDetails.class).buildSessionFactory();
		 
			System.out.println("DONE!");
	
	
	//creating session object to get current session
		Session session=factory.openSession();
	
	try {
	//create Annotated class POJO
		email=detailsJson.getEmail();
		String password=detailsJson.getPassword();
		
		JSONObject jsonDetails = new JSONObject(detailsJson);
		String jsonString=jsonDetails.toString();
		
		System.out.println(jsonString);
		
		UserPersonalDetails upd = new UserPersonalDetails(email,password,jsonString);
		
	//start a transaction
		session.beginTransaction();
		
	//save the POJO
		session.save(upd);
		String dbJsonString=null;
		List<UserPersonalDetails> userDetails=session.createQuery("from UserPersonalDetails where email = '"+email+"'").getResultList(); //Write Class Name in query
		System.out.println("Got results from UPD.");
		for(UserPersonalDetails temp:userDetails) {
		System.out.println(temp);
		dbJsonString=temp.getDetailsJson();		
		}
	//commit transaction
		
		
		
	//								JSON STRING TO POJO	
   /**///============================================================================================/**/
   /**/	//Converting JSON String to POJO															 /**/
   /**/	 ObjectMapper mapper = new ObjectMapper();													 /**/
   /**/        DetailsJson readValue = mapper.readValue(dbJsonString, DetailsJson.class);            /**/
   /**/        System.out.println("readValue = " + readValue);                                       /**/
   /**/        System.out.println("EMAIL FROM DB JSON:"+readValue.getEmail());                       /**/
   /**/        																						 /**/
   /**/        responseEmail=readValue.getEmail();												     	 /**/
   /**///============================================================================================/**/       
	        
				
		
		
		session.getTransaction().commit();
	}
	finally {
		//close the session factory
		factory.close();
	}
				
		
		RegistrationResponse registerResponse = new RegistrationResponse(responseEmail, true, "Redirect to Login Page");
		return registerResponse;
	}
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//	
	//READING OTP, VERIFYING IT AND DELETING ENTRY FROM UNVERIFIED ENTRIES
	//===========================================================================================================================================
	
	@PostMapping("/verifyotp")
	public VerificationResponse verifyOtp(@RequestBody ReadOtp otpObject) {
	
		String otpFromDb=null;
		boolean verified=false;
		
		
		List<UnverifiedEntries> usersList;
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UnverifiedEntries.class).buildSessionFactory();

			System.out.println("Factory created");
		Session session=factory.openSession();
		System.out.println("Session Opened");
	
	try {
		session.beginTransaction();
		usersList=session.createQuery("from UnverifiedEntries u where u.unverifiedEmail='"+otpObject.getEmail()+"'").getResultList(); //Write Class Name and Property name in query
		for(UnverifiedEntries ue:usersList) {
			otpFromDb=ue.getCurrentOtp();
		}
		session.getTransaction().commit();
	}
	finally {
		factory.close();
	}
	
	if(otpFromDb.equals(otpObject.getOtp())){
		verified=true;
		
		new Thread(()-> {
			DeleteOtpEntry doe = new DeleteOtpEntry();
			doe.deleteEntryFromDB(otpObject.getEmail());
		}).start();
		
	}

	
	
	VerificationResponse verificationResponse = new VerificationResponse(otpObject.getEmail(),verified);
	
	
	return verificationResponse;
		
		
	}
	
	
	
	
	
	
	
	//===========================================================================================================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
}//CLASS ENDS HERE

