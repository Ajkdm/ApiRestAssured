package practice1;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
public class API_Chaining_CreateUser
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void createUser(ITestContext context) 
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "TestUser2");
		data.put("email", "testuser12345@demo.com");
		
		
		int id=given()
			.header("Authorization","Bearer"+token)
			.contentType(ContentType.JSON)
			.body(data)
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		System.out.println(id);
		context.setAttribute("user_id", id);
		
	}
}
