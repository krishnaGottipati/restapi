package users;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static helpers.RequestHelpers.*;
import static helpers.VerifyHelpers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.basePath;

import ra.Base;

/*
implement getrequest without headers  -- done
implement getrequest with headers
implement getrequest with authorization
*/
public class RetrieveUsersTest extends Base {

	

	@BeforeTest
	public void baseTest() {
		baseURI = "https://reqres.in/";
		basePath = basePath("api/users?page=2");
		String path = baseURI + basePath;
		
		response = getrequest(path);           // --- send a request without params
		//response = getrequest(path, params); //  -- send a request with params
		//response = getrequest(path, params, bearerToken)   //-- send a request with auth
		}

	@Test
	public void validate_statuscode() {
		verifyStatusCode(200);
		verifyStatusLine("HTTP/1.1 200 OK");
		verifyHeaderValue("Content-Type", "application/json; charset=utf-8");
		response.getSessionId();
	}

	@Test
	public void get_particular_user() {
		verifyJsonValue("data[0].first_name", "Michael");

	}

}
