package howManyWaysToCreateRequestBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestPostUsingExternalJSONFile 
{
	@Test
	public void testPostUsingExternalJson() throws Exception 
	{
		File file=new File("./JSON Files/body1.json");
		FileReader rd=new FileReader(file);
		
		JSONTokener jt=new JSONTokener(rd);
		
		JSONObject data=new JSONObject(jt);
		
		given()
			.body(data.toString())
		.when()
		.then();
		
	}

}
