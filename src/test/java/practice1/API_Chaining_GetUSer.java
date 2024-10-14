package practice1;

import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class API_Chaining_GetUSer 
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void getUSer(ITestContext context) 
	{
		int id=(Integer)context.getAttribute("user_id");
		given()
			.header("Authorization","Bearer"+token)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200);
	}
}
