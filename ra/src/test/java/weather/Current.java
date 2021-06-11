package weather;

import static helpers.RequestHelpers.*;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ra.Base;

public class Current extends Base{
	
	@BeforeTest
	public void baseTest() {
		baseURI = "https://samples.openweathermap.org/";
		basePath = basePath("data/2.5/weather");
		String path = baseURI + basePath;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("q", "London");
		params.put("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8");
		response = getrequest(path, params);
	}
	
	
	@Test
	public void verify() {
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
	}
	
	
	public void retrieve_weather_condition_by_city_name() {
		
		
	}

}
