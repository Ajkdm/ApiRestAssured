package practice1;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class API_Chaining_WithinClass
{
	int id;
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test(priority=1)
	public void createUser() 
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "TestUser1");
		data.put("email", "testuser1234@demo.com");
		
		 id=given()
			.header("Authorization","Bearer"+token)
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
	}
	
	@Test(priority=2)
	public void updateUser() 
	{
		HashMap<String,String> data=new HashMap<>();
		data.put("name", "TestUser12");
		data.put("email", "testuser123456@demo.com");
		
		 given()
		 	.header("Authorization","Bearer"+token)
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://gorest.co.in/public/v2/users/"+id)
		.then()
			.statusCode(200);
		
	}
	
	@Test(priority=3)
	public void deleteUser() 
	{
		 given()
		 	.header("Authorization","Bearer"+token)
		.when()
			.delete("https://gorest.co.in/public/v2/users/"+id)
		.then()
			.statusCode(200);
		
	}
}
