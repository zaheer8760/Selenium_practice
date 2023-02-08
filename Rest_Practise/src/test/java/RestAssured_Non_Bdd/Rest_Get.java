package RestAssured_Non_Bdd;

import java.io.File;

import org.apache.commons.collections4.Get;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest_Get {

//	@Test
	public void Test01_Get() {
		
		RestAssured.baseURI ="http://localhost:3000/";
		RequestSpecification requestSpecification = RestAssured.given();
		Response respose = requestSpecification.request(Method.GET,"users");
		
		System.out.println(respose.asPrettyString());
		System.out.println(respose.getStatusCode());
		System.out.println(respose.getStatusLine());
		
	}
	
	@Test
	public void Test02_Post() {
		
		File file = new File("data.json");
		RestAssured.baseURI = "http://localhost:3000/";
		
		Response post = RestAssured.given().header("Content-Type","application/json").
		                    contentType(ContentType.JSON).accept(ContentType.JSON).
		                    body(file).when().post("users");
		
		System.out.println(post.asPrettyString());
		System.out.println(post.getStatusCode());
		System.out.println(post.getStatusLine());
	}
	
	@Test(enabled = false)
	public void updateUser() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Mahatma");
		request.put("lastName","Gandhi");
		request.put("subjectId", 1);
		
		
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification requestSpecification2 = RestAssured.given().header("Content-Type","application/json").body(request.toJSONString());
		Response responce = requestSpecification2.request(Method.PUT,"users/6");
		System.out.println(responce.getStatusCode());
		
	}
	
	@Test(enabled = false)
	public void deteleUser() {
		
		RestAssured.baseURI = "http://localhost:3000/";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.DELETE,"users/6");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}
}
