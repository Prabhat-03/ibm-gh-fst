package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GithubProject {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String ssh;
	int id;
	@BeforeClass
	public void setUp() {

		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://api.github.com/")
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "token <github secret>")
				.build();
	}


	@Test(priority=1)
	public void postRequest() {
		String reqBody = "{\"title\":\"TestAPIKey\", \"key\":\"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHoq4lqm4Ake8+qsGfPwhq1GKsyofGlLE1evpdwDShfn\"}";
		
		Response response = given().spec(requestSpec) 
		.body(reqBody) 
		.when()
		.post("/user/keys");
		
		
		response.prettyPrint();		
		id = response.jsonPath().getInt("id");
		response.then().statusCode(201);

	}
	


	@Test(priority=2)
	public void getRequest() {
		Response res = given().spec(requestSpec) 
			.pathParam("keyId", id) 
		.when()
			.get("/user/keys/{keyId}");;
		
        Reporter.log(res.asPrettyString(), true);
        
        assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority=3)
	public void deletePets() {
		Response res = given().spec(requestSpec) 
			.pathParam("keyId", id) 
		.when()
			.delete("/user/keys/{keyId}");
		
		Reporter.log(res.asPrettyString(), true);
		assertEquals(res.getStatusCode(), 204);

	}
}
