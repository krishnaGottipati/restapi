package helpers;

import ra.Base;

public class ResponseHelpers extends Base{
	
	public static String sessionID() {
		String sessionID = response.getSessionId();
		return sessionID;
	}

	public static int statusCode() {
		int statuscode = response.getStatusCode();
		return statuscode;
	}

	public static String statusLine() {
		String statuscode = response.getStatusLine();
		return statuscode;
	}

	public static String body() {
		String body = response.getBody().asString();
		System.out.println(body);
		return body;
	}

	public static String headerValue(String headerkey) {
		String headervalue = response.header(headerkey);
		System.out.println("Header key" + headerkey + " is " + headervalue);
		return headervalue;
	}

	public static String jsonValue(String jsonKey) {
		// ResponseBody body = response.getBody();

		String JsonValue = response.jsonPath().getString(jsonKey);

		System.out.println(JsonValue);

		return JsonValue;

	}


}
