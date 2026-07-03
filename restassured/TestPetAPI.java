package restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPetAPI {

    @Test
    public void GetPetDetails() {
        // Specify the base URL to the RESTful web service
        baseURI = "https://petstore.swagger.io/v2/pet/findByStatus";

        // Make a request to the server by specifying the method Type and 
        // resource to send the request to.
        // Store the response received from the server for later use.
        
        
//        Response response = 
//            given().contentType(ContentType.JSON) // Set headers
//            .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

        Response response = 
        		given().contentType(ContentType.JSON)
        		.when()
        		.queryParam("status", "always alive")
        		.get(baseURI);
        		
        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().prettyPrint();
//        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
    }
    
    
	
@Test	
public void getIPInformation() {
	String ROOT_URI = "http://ip-api.com/json/{ipAddress}";
//    Response response = 
//        given().contentType(ContentType.JSON) // Set headers
//        .when()
//        .pathParam("ipAddress", "103.176.234.18") // Set path parameter	
//        .get(ROOT_URI); // Send GET request
//	
	
	Response response = given().contentType(ContentType.JSON)
						.when()
						.queryParam("fields","query,country,city,timezone")
						.pathParam("ipAddress", "103.176.234.18")
						.get(ROOT_URI);
	
    // Print response
    System.out.println(response.getBody().asPrettyString());
	
}

}