package responsebodyValidations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation
{
	public void schemaValidation() 
	{
		given()
		.when()
			.get("")
		.then();
			//.assertThat().body(JsonSchemaValidator.MatchesJsonSchemaInClassPath("TestSchema.json"));
	}
}
