package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CustomActivity1 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	static long id;
	@BeforeClass
	public void setUp() {
		requestSpec = new RequestSpecBuilder()
			.addHeader("Content-Type", "application/json")
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			.build();

		responseSpec = new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType("application/json")
			.expectBody("status", equalTo("alive"))
			.build();
	}

	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ "Yshesh", "alive" }, 
			{ "Hoiii", "alive" } 
		};
		return testData;
	}

	@Test(priority=1, dataProvider = "petInfo")
	public void addPets(String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
//		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		Response response = given().spec(requestSpec) 
		.body(reqBody) 
		.when()
		.post();
		
		id = response.body().path("id");

	}
	


	@Test(priority=2, dataProvider = "petInfo")
	public void updatePets(String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", id);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(requestSpec) 
		.body(reqBody) 
		.when()
		.post() 
		.then().spec(responseSpec)
		.body("name", equalTo(petName));
	}
	
	@Test( priority=3)
	public void getPets() {
		given().spec(requestSpec) 
			.pathParam("petId", id) 
			.log().all() 
		.when()
			.get("/{petId}") 
		.then().spec(responseSpec) 
		    .log().all();
	}

	@Test(priority=4)
	public void deletePets() {
		given().spec(requestSpec) 
			.pathParam("petId", id) 
		.when()
			.delete("/{petId}");
	}
	
	
	@Test( priority=5)
	public void getPet() {
		 given().spec(requestSpec) 
		.pathParam("petId", id) 
		.then().statusCode(400);
	}
}
