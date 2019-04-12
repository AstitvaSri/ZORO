package com.rest.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//CHECKING EXISTING EMAIL AND SENDING OTP IF EMAIL NOT EXISTS, ALSO SAVING OTP TO DATABASE
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/checkexistence/{newEmail}")
	public Existence checkNewEmail(@PathVariable String newEmail) {
					boolean exist=false;

					System.out.println(newEmail);
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
		
		List<UserPersonalDetails> usersList;
		
		try {
			session.beginTransaction();
			usersList=session.createQuery("from UserPersonalDetails u where u.email='"+detailsJson.getEmail()+"'").getResultList(); //Write Class Name and Property name in query
		
			session.getTransaction().commit();
		}
		finally {}
		
if(!(usersList.isEmpty())) {
	
	try {
		session.beginTransaction();
		Object obj=session.createQuery("from UserPersonalDetails u where u.email='"+detailsJson.getEmail()+"'").getSingleResult(); //Write Class Name and Property name in query
		session.delete(obj);
		session.getTransaction().commit();
	}
	finally {
		System.out.println("Old Entry Deleted!");
	}
}		
		
		
	try {
	//create Annotated class POJO
		email=detailsJson.getEmail();
		
		JSONObject jsonDetails = new JSONObject(detailsJson);
		String jsonString=jsonDetails.toString();
		
		System.out.println(jsonString);
		
		UserPersonalDetails upd = new UserPersonalDetails(email,jsonString);
	
		
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
		session.getTransaction().commit();
		
		
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
	        
				
		
		
		
	}
	finally {
		//close the session factory
		factory.close();
	}
				
		
		RegistrationResponse registerResponse = new RegistrationResponse(responseEmail, true, "details saved");
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
	
	@GetMapping("/verifyotp/{recString}")
	public VerificationResponse verifyOtp(@PathVariable String recString) {

		System.out.println(recString);
	
		
		String words[] = recString.split("--");
		System.out.println(words[0]);
		System.out.println(words[1]);
		
		String emailStr = words[0];
		String otpStr = words[1];
		
		ReadOtp otpObject = new ReadOtp(emailStr, otpStr);
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
	
	
	
	//==================================NEW VERIFIED USER (MENTION IT IN CREDENTIALS TABLE)============================++++++++++++===============
	
	@PostMapping("/registerCredentials")
	public RegistrationResponse newUserCredentials(@RequestBody Credentials cred) throws JsonParseException, JsonMappingException, IOException {		
		System.out.println("DONE!");
		String email=cred.getEmail();
		String password=cred.getPassword();
		System.out.println("DONE!");
		
		
		System.out.println("Starting to read hibernate config...");
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Credentials.class).buildSessionFactory();
		 
			System.out.println("DONE!");
	
	
	//creating session object to get current session
		Session session=factory.openSession();
		
		
		
		
	try {
	//create Annotated class POJO
		
		
		System.out.println("////////////========================////////////////"+cred.getEmail());
		
		Credentials saveThisCred = new Credentials(email,password);
	
		
	//start a transaction
		session.beginTransaction();
		
	//save the POJO
		session.save(saveThisCred);
	//commit transaction    
		session.getTransaction().commit();
	}
	finally {
		//close the session factory
		factory.close();
	}
				
		
		RegistrationResponse registerResponse = new RegistrationResponse(cred.getEmail(), true, "registration done, redirect to login page");
		return registerResponse;
	}
	
	
	
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
	//======================================================LOGIN USER=====================================================================================
	@PostMapping("/login")
	public LoginResponse loginTheUser(@RequestBody LoginUser user) {		
		
		String passwordToMatch=null;
		boolean exist=false;
		
		
		
		List<Credentials> credentials;
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Credentials.class).buildSessionFactory();

			System.out.println("Factory created");
		Session session=factory.openSession();
		System.out.println("Session Opened");
	
	try {
		session.beginTransaction();
		credentials=session.createQuery("from Credentials u where u.email='"+user.getEmail()+"'").getResultList(); //Write Class Name and Property name in query
		exist=(!credentials.isEmpty());
		session.getTransaction().commit();
	}
	finally {
		factory.close();
	}
	
	
	System.out.println("EXIST:"+exist);
	if(!exist) {
		LoginResponse loginResponse = new LoginResponse(user.getEmail(), false, "Invalid Email!");
		return loginResponse;
	}
	
	for(Credentials cred:credentials) {
		passwordToMatch=cred.getPassword();
	}
	if(passwordToMatch.equals(user.getPassword()))
	{
		LoginResponse loginResponse = new LoginResponse(user.getEmail(), true,"Logged in successfully, redirect to dashboard.");
		return loginResponse;
	}
	
	LoginResponse loginResponse = new LoginResponse(user.getEmail(), false, "Invalid Password!");
	
	

return loginResponse;
}	
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------
	//
//	//
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
	//-------------------------------------------------------SEND USER DETAILS TO DASHBOARD-----------------------------------------------------------
	//=================================================================================================================================================
	
	
	@GetMapping("/getUserDetails/{user_email}")
	public org.json.simple.JSONObject sendUserDetailsAsJson(@PathVariable String user_email) {
		
		boolean exist = false;
		org.json.simple.JSONObject responseDetails=null;
		List<UserPersonalDetails> usersList;
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserPersonalDetails.class).buildSessionFactory();

			System.out.println("Factory created");
		Session session=factory.openSession();
		System.out.println("Session Opened");
	
	try {
		session.beginTransaction();
		usersList=session.createQuery("from UserPersonalDetails u where u.email='"+user_email+"'").getResultList(); //Write Class Name and Property name in query
		exist=(!usersList.isEmpty());
		session.getTransaction().commit();
	}
	finally {
		factory.close();
	}
	
	
	System.out.println("EXIST:"+exist);
	if(exist){//list is not empty
		for(UserPersonalDetails temp:usersList) {
			String jsonDetailsString = temp.getDetailsJson();
			JSONParser jParser = new JSONParser(); //user json-simple version "1.1" in pom.xml ("1.1.1" will show server error)
			try {
				responseDetails = (org.json.simple.JSONObject) jParser.parse(jsonDetailsString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	
return responseDetails;
		
	}
	
	//=============================================================================================================================================
	//===================================================================================================================================================
	
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
	//=================================================================================================================================================
	//=======================================================================================================================================================
	
	//----------------------------------- ADD NEW PRODUCT TO DATABASE (CATEGORY)-----------------------------------------------------------------------------
	
	
	
	@PostMapping("/addnewproduct")
	public SuccessJSON addProduct(@RequestBody Product newProduct) throws JsonParseException, JsonMappingException, IOException {		
		
		
		System.out.println("Accessing products database...");
		List<ProductsDB> prodList = null;
		
		System.out.println("Starting to read hibernate config...");
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductsDB.class).buildSessionFactory();
		 
			System.out.println("DONE!");
	
	
	//creating session object to get current session
		Session session=factory.openSession();
		
		
		try {
			session.beginTransaction();
			prodList = session.createQuery("from ProductsDB p where p.pid='"+newProduct.getPid()+"'").getResultList(); //Write Class Name and Property name in query
		
			session.getTransaction().commit();
			
		}
		finally {}
		
if(!(prodList.isEmpty())) {
	int oldPid;
	try {
		session.beginTransaction();		
		Object obj=session.createQuery("from ProductsDB p where p.pid='"+newProduct.getPid()+"'").getSingleResult(); //Write Class Name and Property name in query
		oldPid = newProduct.getPid();
		session.delete(obj);
		session.getTransaction().commit();
	}
	finally {
		System.out.println("Old entry is going to be updated...");
	}
	
	//updating old entry with old pid
	try {
		//create POJO
		ProductsDB addThisProduct = new ProductsDB(oldPid,newProduct.getTitle(),newProduct.getRating(), newProduct.getLocation(),
				newProduct.getImg(),newProduct.getCateg(),newProduct.getPrice(),newProduct.getEmail(),newProduct.getDescription(),
				newProduct.getAvf(),newProduct.getAvu());
		
		//start a transaction
				session.beginTransaction();
				
			//save the POJO
				System.out.println("Saving product details....");
				
				session.save(addThisProduct);
				
				System.out.println("Saved!");
			//commit transaction 
				session.getTransaction().commit();
		
		
	}	
	
	
	finally {
		System.out.println("Old Entry Updated!");
	}
}//if closed here	


else {
	int newpid=-1;
	
	//getting next PID
	try {
		
		session.beginTransaction();
		List<ProductsDB> plist = session.createQuery("from ProductsDB p" ).getResultList(); //Write Class Name and Property name in query
		int size = plist.size();
		newpid = plist.get(size-1).getPid();
		System.out.println("Max pid in DB : "+newpid);
		session.getTransaction().commit();
	}
	finally {
		newpid = newpid + 1;
		System.out.println("New pid is : "+newpid);
		
	}
	
	
	
		
	try {
		//create POJO
		ProductsDB addThisProduct = new ProductsDB(newpid,newProduct.getTitle(),newProduct.getRating(), newProduct.getLocation(),
				newProduct.getImg(),newProduct.getCateg(),newProduct.getPrice(),newProduct.getEmail(),newProduct.getDescription(),newProduct.getAvf(),
				newProduct.getAvu());
		
		//start a transaction
				session.beginTransaction();
				
			//save the POJO
				System.out.println("Saving product details....");
				
				session.save(addThisProduct);
				
				System.out.println("Saved!");
			//commit transaction 
				session.getTransaction().commit();
		
		
	}

 
	finally {
		//close the session factory
		factory.close();
	}
}//else closed here		
		
		SuccessJSON success = new SuccessJSON(true);
		
		return success;
	}
	
	
	
	
	

	
	
	//============================================================================================================================================
	
	//--------------------------------------- SEND JSON ARRAY ALL PRODUCTS---------------------------------------------------------------------------------------

	@GetMapping("/allProducts")
	public List<ProductsDB> sendAllProducts() {
		
		List<ProductsDB> prodList;
		
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductsDB.class).buildSessionFactory();

			System.out.println("Factory created");
		Session session=factory.openSession();
		System.out.println("Session Opened");
	
	try {
		session.beginTransaction();
		prodList=session.createQuery("SELECT a FROM ProductsDB a", ProductsDB.class).getResultList(); //Write Class Name and Property name in query
		session.getTransaction().commit();
	}
	finally {
		factory.close();
	}
	
	System.out.println("Old Size : "+prodList.size());
	
	int rem=0;
	int size = prodList.size();
	if(size%3 != 0) {
		rem = size%3;
	}
	
	if(rem!=0) {
		List<ProductsDB> toRemove = new ArrayList<ProductsDB>();
		for(ProductsDB pro: prodList){
				if(rem==0) {
					break;
				}
				rem--;
				toRemove.add(pro);
			}
		prodList.removeAll(toRemove);
	}
	
	System.out.println("New Size : "+prodList.size());
	
return prodList;
		
	}	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------- SEND PRODUCTS BASED ON CATEGORY --------------------------------------------------------------------------------------

	@GetMapping("/getCategory/{search_query}")
	public List<ProductsDB> categoryBasedProducts(@PathVariable String search_query) {
			
			List<ProductsDB> prodList;
			
			search_query = search_query.toLowerCase();
			
			 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductsDB.class).buildSessionFactory();

				System.out.println("Factory created");
			Session session=factory.openSession();
			System.out.println("Session Opened");
		
		try {
			session.beginTransaction();
			prodList=session.createQuery("SELECT a FROM ProductsDB a where a.categ = '"+search_query+"'", ProductsDB.class).getResultList(); //Write Class Name and Property name in query
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		System.out.println("Old Size : "+prodList.size());
		
		int rem=0;
		int size = prodList.size();
		if(size%3 != 0) {
			rem = size%3;
		}
		
		if(rem!=0) {
			List<ProductsDB> toRemove = new ArrayList<ProductsDB>();
			for(ProductsDB pro: prodList){
					if(rem==0) {
						break;
					}
					rem--;
					toRemove.add(pro);
				}
			prodList.removeAll(toRemove);
		}
		
		System.out.println("New Size : "+prodList.size());
		
	return prodList;
			
		}	
		
//=============================================================================================================================================================================================================================

}//CLASS ENDS HERE

