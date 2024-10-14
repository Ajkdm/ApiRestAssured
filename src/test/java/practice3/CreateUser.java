package practice3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUser
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	
	@Test
	public void approach1() 
	{
		HashMap<String,String> map=new HashMap<>();
		map.put("name", "testuser");
		map.put("email", "testuser@demo.com");
		
		
		given()
			.header("Authorization","Bearer"+token)
			.contentType("application/json")
			.body(map)
		.when()
			.post("https://gorest.co.in/public/v2/users")
		.then()
			.statusCode(201);
	}
}
