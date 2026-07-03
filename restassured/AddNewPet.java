package restAssured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddNewPet {
	String ROOT_URL = "https://petstore.swagger.io/v2/pet";
	
	@Test
	public void AddNewPet() {
		String reqBody = "{\"id\": 777771,\"name\":\"Rorona Zoro\", \"status\":\"always alive\"}";
		
		Response response = given().contentType(ContentType.JSON)
							.body(reqBody)
							.when()
							.post(ROOT_URL);
		
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		
        response.then().statusCode(200);
	}
	
	 public void GetPetDetails() {
	        baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";
	        Response response = 
	        		given().contentType(ContentType.JSON)
	        		.when()
	        		.queryParam("status", "alwayysss alive")
	        		.get(baseURI);
	        		
	        String responseBody = response.getBody().prettyPrint();

	        response.then().statusCode(200);
	    }
}
