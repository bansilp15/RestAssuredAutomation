package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExample {
	
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[711].first_name", equalTo("Bansil")).
			body("data.first_name", hasItems("Tobias","George", "Rachel")).log().all();
	}
	
	@Test
	public void testPost() {	
		JSONObject request = new JSONObject();
		request.put("name", "Bansil");
		request.put("job", "QA Analyst");
		
		baseURI = "https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
}
