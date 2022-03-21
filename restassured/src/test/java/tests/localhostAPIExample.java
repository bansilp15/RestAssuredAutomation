package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class localhostAPIExample {
	
	//@Test
	public void testGet() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then()
			.statusCode(200).
			log().all();
		}
	//@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Pruthvi");
		map.put("lastName", "Chavda");
		map.put("subjectId", 2);
		
		JSONObject request = new JSONObject(map);
		
		baseURI = "http://localhost:3000";
		
		given().
			accept(ContentType.JSON).
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
			
	}
	
	//@Test
	public void testPut() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Yash");
		map.put("lastName", "Amin");
		map.put("subjectId", 2);
		
		JSONObject request = new JSONObject(map);
		
		baseURI = "http://localhost:3000";
		
		given().
			accept(ContentType.JSON).
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/3").
		then().
			statusCode(200);
			
	}
	//@Test
	public void testPatch() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lastName", "Vaghri");
		map.put("subjectId", 1);
		
		JSONObject request = new JSONObject(map);
		
		baseURI = "http://localhost:3000";
		
		given().
			accept(ContentType.JSON).
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/3").
		then().
			statusCode(200);
			
	}
	
	@Test
	public void testDelete() {
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/3").
		then().
			statusCode(204);
	}
}
