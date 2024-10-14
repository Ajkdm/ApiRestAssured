package practice3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class StatusCodeValidation
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	
	@Test
	public void Approach1() 
	{
	 given()
	 	.header("Authorization","Bearer"+token)
	 .when()
		.get("https://gorest.co.in/public/v2/users")
	 .then()
		.statusCode(200);
	}
	
	@Test
	public void Approach2() 
	{
	 Response res = given()
	 	.header("Authorization","Bearer"+token)
	 .when()
		.get("https://gorest.co.in/public/v2/users");
	 
	 Assert.assertEquals(res.getStatusCode(),200);
	}
	
	
}
