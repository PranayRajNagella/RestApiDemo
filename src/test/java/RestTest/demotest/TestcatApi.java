package RestTest.demotest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class TestcatApi extends BaseTest {
	
	@Test()
	public void testApi()
	{
		RestAssured.baseURI="https://cat-fact.herokuapp.com";
		
		HashMap<String, Object> QueryMap=new HashMap<String,Object>();
		QueryMap.put("animal_type","cat");
		QueryMap.put("amount",11);
		
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Accept","application/json");
		headerMap.put("content-type","application/json");
		
		Response response=given().log().all().queryParams(QueryMap).headers(headerMap).when().get("/facts")
				.then().log().all().assertThat().statusCode(200).extract().response();
		String resp=response.asString();
		System.out.println(resp);
		JsonPath jp=new JsonPath(resp);
     	System.out.println(jp.getString("_id"));
	}

}
