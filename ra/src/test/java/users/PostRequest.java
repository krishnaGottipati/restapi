package users;

import static helpers.RequestHelpers.*;
import static helpers.VerifyHelpers.*;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import payload.myPojo;
import ra.Base;

public class PostRequest extends Base{
	myPojo body;
	String path;
	
	@BeforeTest
	public void baseTest() {
		baseURI = "https://reqres.in/";
		basePath = basePath("api/register");
		path = baseURI + basePath;		
		body = new myPojo();
	}
	
	@Test(priority = 0)
	public void pass_valid() {
		
		body.setEmail("eve.holt@reqres.in");
		body.setPassword("pistol");	
		response = postRequest(path, body);  
		verifyJsonValue("id", "4");
		verifyJsonValue("token", "QpwL5tke4Pnpja7X4");
		verifyStatusCode(200);
	}
	
	@Test(priority = 1)
	public void pass_invalid() {
		
		body.setEmail("eve.holtkgg@reqres.in");
		body.setPassword("pistol");
		
		response = postRequest(path, body); 
		verifyJsonValue("error", "Note: Only defined users succeed registration");
		verifyStatusCode(400);
	}
	
	@Test(priority = 2)
	public void pass_onlyEmail() {
		body.setEmail("eve.holt@reqres.in");
		
		response = postRequest(path, body); 
		verifyJsonValue("error", "Missing password");
		verifyStatusCode(400);
		
	}

	
	

}
