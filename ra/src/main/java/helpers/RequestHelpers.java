package helpers;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.myPojo;
import ra.Base;

public class RequestHelpers extends Base {

	public static Response getrequest(String path) {
		Response response = get(path);
		return response;
	}

	// getrequest with authentication
	public static Response getrequest(String path, Map<String, Object> params, String auth) {
		RequestSpecification spec = given().params(params).auth().oauth2(auth);
		Response response = spec.get(path);
		return response;
	}

	// getrequest with params
	public static Response getrequest(String path, Map<String, Object> params) {

		Response response = given().params(params).get(path);
		return response;
	}

	public static Response postRequest(String path, myPojo body) {

		Response response = given().contentType(ContentType.JSON).body(body).post(path);

		System.out.println(response);

		System.out.println(response.getStatusCode());
		System.out.println(response.body().asString());
		return response;
	}

	public static String basePath(String params) {

		basePath = params;
		return basePath;

	}

}
