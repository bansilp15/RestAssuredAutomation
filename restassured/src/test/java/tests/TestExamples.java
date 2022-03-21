package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void testOne() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getTime());
		
		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getHeader("content-type"));
		
		int actualStatusCode = response.getStatusCode();
		
		int expectedStatusCode = 200;
		
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	
	@Test
	public void testTwo() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].id", equalTo(9)).
			log().all();
	}
	
}

	
