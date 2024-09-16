package basicValidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class APIRequests 
{
	int id;
	@Test(priority=1)
	public void getRequest() 
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	@Test (priority=2)
	public void createUser() 
	{
		HashMap data=new HashMap();
		data.put("name", "User1");
		data.put("job", "Trainer");
		
		id=given()
				.contentType("application/json")
				.body(data)
		   .when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");
	}
	
	@Test(priority=3)
	public void updateUser() 
	{
		HashMap data=new HashMap();
		data.put("name", "User2");
		data.put("job", "teacher");
		
			given()
				.contentType("application/json")
				.body(data)
		   .when()
				.put("https://reqres.in/api/users/"+id)
		   .then()
		   		.statusCode(200)
		   		.log().all();
	}
	
	
	@Test(priority=4)
	public void deleteUser() 
	{
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
	
}
