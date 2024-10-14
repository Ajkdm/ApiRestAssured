package practice1;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class API_Chaining_UpdateUser
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void updateUser(ITestContext context) 
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "TestUser2");
		data.put("email", "testuser12345@demo.com");
		
		int id=(Integer)context.getAttribute("user_id");
		
		given()
			.header("Authorization","Bearer"+token)
			.contentType(ContentType.JSON)
			.body(data)
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200);
	}
}
