package tests;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {
	@Test
	public void testPut() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Bansil");
		map.put("job", "QA Analyst");
		
		JSONObject request = new JSONObject(map);
		
		baseURI = "https://reqres.in/";
		
		given().
			header("Content-Type", "applications/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("api/users/2").
		then().
			statusCode(200).
			log().all();	
	}
	
	@Test
	public void testPatch() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Bansil");
		
		JSONObject request = new JSONObject(map);
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "applications/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();	
	}

	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204);
		
	}
}
