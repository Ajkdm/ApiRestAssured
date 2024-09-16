package responceValidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Coockies 
{
	@Test
	public void cookies() 
	{
		given()
		.when()
			.get("")
		.then()
			.cookie("AEC","Value");
	}
}
