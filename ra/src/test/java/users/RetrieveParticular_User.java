package users;

import static helpers.VerifyHelpers.*;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ra.Base;

public class RetrieveParticular_User extends Base{
	
	@Test
	public void validate_statuscode() {
		System.out.println(basePath);
		
		System.out.println("RetrieveParticular_User response is  " + response);

		verifyStatusCode(200);
		verifyStatusLine("HTTP/1.1 200 OK");
		verifyHeaderValue("Content-Type", "application/json; charset=utf-8");
		response.getSessionId();
	}

	@Test
	public void get_particular_user() {
		System.out.println(basePath);
		verifyJsonValue("data.email", "janet.weaver@reqres.in");

	}

}
