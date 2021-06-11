package helpers;

import static helpers.ResponseHelpers.*;
import static org.testng.Assert.assertEquals;

import ra.Base;

public class VerifyHelpers extends Base{
	

	public static void verifyStatusCode(int statuscode) {
		int verifyStatusCode = statusCode();
		assertEquals(verifyStatusCode, statuscode);
	}
	
	public static void verifyStatusLine(String statusLine) {
		String verifyStatusLine = statusLine();
		assertEquals(verifyStatusLine, statusLine);
	}
	
	public static void verifyHeaderValue(String header_key, String header_value) {
		String header = headerValue(header_key);
		assertEquals(header, header_value);	
		
		//"Content-Type", "application/json; charset=utf-8"
	}
	
	public static void verifyJsonValue(String Json_key, String Json_value) {
		String value = jsonValue(Json_key);
		assertEquals(value , Json_value);
	}

}
