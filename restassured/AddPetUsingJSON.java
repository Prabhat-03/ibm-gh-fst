package restAssured;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddPetUsingJSON {
String ROOT_URL = "https://petstore.swagger.io/v2/pet";
	
	@Test
	public void AddNewPet() {
		String reqBody = "{\"id\": 777771,\"name\":\"Rorona Zoro\", \"status\":\"always alive\"}";
		File file = new File("src/test/resources/content.json");
		
		Response response = given().contentType(ContentType.JSON)
							.body(file)
							.when()
							.post(ROOT_URL);
		
		String body = response.getBody().asPrettyString();
		System.out.println(body);
	
	    // Assertion
	    response.then().body("id", equalTo(77232));
	    response.then().body("name", equalTo("Riley"));	
	}
}
