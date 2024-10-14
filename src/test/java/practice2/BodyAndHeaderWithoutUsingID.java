package practice2;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class BodyAndHeaderWithoutUsingID
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void printFieldofJsonObject() 
	{
		Response res=given()
			.header("Authorization","Bearer"+token)
			.contentType("ContentType/json")
		.when()
			.get("https://gorest.co.in/public/v2/users");
		
		//JSONArray ja=new JSONArray(res.asString());
		
		String name = res.jsonPath().get("[0].name").toString();
		//or
		//String name = res.jsonPath().getString("[0].name").toString();
		
		System.out.println("name is " +name);
		//System.out.println("Email is "+res.jsonPath().getString("[0].email"));
		//or
		System.out.println("Email is "+res.jsonPath().get("[0].email").toString());
		
		System.out.println("Here is the response "+res);
			
	}
	
	@Test
	public void printTotalNumberOfObjects() 
	{
		int res=given()
			.header("Authorization","Bearer"+token)
			.contentType("ContentType/json")
		.when()
			.get("https://gorest.co.in/public/v2/users")
		.then()
			.extract().jsonPath().getInt("size()");
		
		System.out.println(res);	
	}
	
	@Test
	public void printJsonFields_Approach1() 
	{
		JsonPath jsonPath=given()
			.header("Authorization","Bearer"+token)
			.contentType("ContentType/json")
		.when()
			.get("https://gorest.co.in/public/v2/users")
		.then()
			.extract().jsonPath();
		int count=jsonPath.getInt("size()");
		
		for(int i=0;i<count;i++) 
		{
			String name=jsonPath.getString("["+i+"].name");
			String email=jsonPath.getString("["+i+"].email");
			System.out.println(i+") name is "+name);
			System.out.println("email is "+email);
			System.out.println();
		}	
	}
	
	
	@Test
	public void printJsonFields_Approach2() 
	{
		given()
			.header("Authorization","Bearer"+token)
			.contentType(ContentType.JSON)
		.when()
			.get("https://gorest.co.in/public/v2/users")
		.then()
			.body("[0].name", Matchers.equalTo("Vaishvi Ahuja LLD"));
	}
	
	@Test
	public void printJsonFields_Approach5() 
	{
	Response res = given()
		.header("Authorization","Bearer"+token)
		.contentType(ContentType.JSON)
	.when()
		.get("https://gorest.co.in/public/v2/users");
	
	JsonPath jsonPath = res.jsonPath();
	int size = jsonPath.getInt("size()");
	System.out.println(size);
	
	for(int i=0;i<size;i++) 
	{
		System.out.println(jsonPath.get("["+i+"].name").toString()+"<--->"+jsonPath.get("["+i+"].email").toString());
		System.out.println(jsonPath.get("["+i+"].name").toString());
	}
	
	
	}
}
