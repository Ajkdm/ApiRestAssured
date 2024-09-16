package responceValidations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class StatusCodeValidation
{
	@Test
	public void statusCodes() 
	{
	given()
	.when()
		.get("https://reqres.in/api/users")
	.then()
		.statusCode(200);
		
	}
}
