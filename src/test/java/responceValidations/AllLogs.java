package responceValidations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AllLogs 
{
	@Test
	public void allLogs() 
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			//.log().body();
			//.log().cookies();
			//.log().headers();
			.log().all();
	}
}
