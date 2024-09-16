package responceValidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HeaderValidation 
{
	@Test
	public void headerValidation() 
	{
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Content-Encoding","gzip")
			.header("Server","gws");
			
	}
}
