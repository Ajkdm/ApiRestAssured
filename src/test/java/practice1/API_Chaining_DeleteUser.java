package practice1;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class API_Chaining_DeleteUser 
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void deleteUSer(ITestContext context) 
	{
		int id=(Integer)context.getAttribute("user_id");
		given()
			.header("Authorization","Bearer"+token)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200);
	}
}
