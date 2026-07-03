package restAssured;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class DeletePet {
String ROOT_URL = "https://petstore.swagger.io/v2/pet/{petID}";
	
	@Test
	public void deletePet() {
		Response response = given().contentType(ContentType.JSON)
							.pathParam("petID",777771)
							.when()
							.delete(ROOT_URL);
		
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		
        response.then().statusCode(200);
	}
	
	
	@Test
	 public void GetPetDetails() {
	        baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";
	        Response response = 
	        		given().contentType(ContentType.JSON)
	        		.when()
	        		.queryParam("status", "alwayysss alive")
	        		.get(baseURI);
	        
	        String responseBody = response.getBody().prettyPrint();
	    }
}
