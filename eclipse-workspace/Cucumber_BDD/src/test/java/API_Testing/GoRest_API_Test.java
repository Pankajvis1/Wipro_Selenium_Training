package API_Testing;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GoRest_API_Test {

	public static void main(String[] args) {

		// ================= BASE URI =================

		RestAssured.baseURI = "https://gorest.co.in/public/v2";

		// ================= BEARER TOKEN =================

		String token = "dc72963269e15ea5305603f01a6c440a777c3860885c85e1ab036f252ac67459";

		// ================= GET REQUEST =================

		System.out.println("============== GET REQUEST ==============");

		// GET Request
		Response getResponse =

				given()

						// Authorization Header
						.header("Authorization", "Bearer " + token)

						.when()

						// GET API
						.get("/users");

		// Print Status Code
		System.out.println("Status Code : " + getResponse.getStatusCode());

		// Print Response Body
		System.out.println("Response Body : ");

		System.out.println(getResponse.getBody().asString());

		// Print Response Time
		System.out.println("Response Time : " + getResponse.getTime());

		// Print Content Type
		System.out.println("Content Type : " + getResponse.getContentType());

		// ================= VALIDATIONS =================

		System.out.println("\n============== VALIDATIONS ==============");

		// Response Validations
		given()

				.header("Authorization", "Bearer " + token)

				.when()

				.get("/users")

				.then()

				// Validate Status Code
				.statusCode(200)

				// Validate Content Type
				.contentType(ContentType.JSON)

				// Validate Response Time
				.time(lessThan(5000L))

				// Print Complete Response
				.log().all();

		// ================= JSON EXTRACTION =================

		System.out.println("\n============== JSON EXTRACTION ==============");

		// Convert Response into JsonPath
		JsonPath jsonPath = getResponse.jsonPath();

		// Extract User ID
		int id = jsonPath.getInt("[0].id");

		// Extract Email
		String email = jsonPath.getString("[0].email");

		// Extract Name
		String name = jsonPath.getString("[0].name");

		// Print Extracted Data
		System.out.println("ID : " + id);

		System.out.println("Email : " + email);

		System.out.println("Name : " + name);

		// ================= POST REQUEST =================

		System.out.println("\n============== POST REQUEST ==============");

		// POST Request Body
		String postRequestBody =

				"{\n"

						+ "\"name\":\"Pankaj Vishwakarma\",\n"

						+ "\"gender\":\"male\",\n"

						+ "\"email\":\"pankaj"

						+ System.currentTimeMillis()

						+ "@gmail.com\",\n"

						+ "\"status\":\"active\"\n"

						+ "}";

		// POST Request
		Response postResponse =

				given()

						// Authorization Header
						.header("Authorization", "Bearer " + token)

						// Content Type
						.contentType(ContentType.JSON)

						// Request Body
						.body(postRequestBody)

						.when()

						// POST API
						.post("/users");

		// POST Response Validation
		postResponse.then()

				.statusCode(201)

				.log().all();

		// Extract Generated ID
		int generatedId =

				postResponse.jsonPath().getInt("id");

		System.out.println("Generated ID : " + generatedId);

		// ================= PUT REQUEST =================

		System.out.println("\n============== PUT REQUEST ==============");

		// PUT Request Body
		String putRequestBody =

				"{\n"

						+ "\"name\":\"Updated Pankaj\",\n"

						+ "\"status\":\"inactive\"\n"

						+ "}";

		// PUT Request
		given()

				.header("Authorization", "Bearer " + token)

				.contentType(ContentType.JSON)

				.body(putRequestBody)

				.when()

				.put("/users/" + generatedId)

				.then()

				// Validate Status Code
				.statusCode(200)

				// Validate Updated Name
				.body("name", equalTo("Updated Pankaj"))

				.log().all();

		// ================= DELETE REQUEST =================

		System.out.println("\n============== DELETE REQUEST ==============");

		// DELETE Request
		given()

				.header("Authorization", "Bearer " + token)

				.when()

				.delete("/users/" + generatedId)

				.then()

				// Validate Status Code
				.statusCode(204)

				.log().all();

		// ================= PATH PARAMETER =================

		System.out.println("\n============== PATH PARAMETER ==============");

		// Path Parameter Example
		given()

				.header("Authorization", "Bearer " + token)

				.pathParam("id", id)

				.when()

				.get("/users/{id}")

				.then()

				.statusCode(200)

				.log().all();

		// ================= QUERY PARAMETER =================

		System.out.println("\n============== QUERY PARAMETER ==============");

		// Query Parameter Example
		given()

				.header("Authorization", "Bearer " + token)

				.queryParam("page", 1)

				.when()

				.get("/users")

				.then()

				.statusCode(200)

				.log().all();

		// ================= HEADERS =================

		System.out.println("\n============== HEADERS ==============");

		// Header Validation Example
		given()

				.header("Authorization", "Bearer " + token)

				.header("Content-Type", "application/json")

				.when()

				.get("/users")

				.then()

				.statusCode(200)

				.log().headers();

		// ================= REQUEST CHAINING =================

		System.out.println("\n============== REQUEST CHAINING ==============");

		// POST Request
		Response chainResponse =

				given()

						.header("Authorization", "Bearer " + token)

						.contentType(ContentType.JSON)

						.body(postRequestBody)

						.when()

						.post("/users");

		// Extract ID
		int chainId =

				chainResponse.jsonPath().getInt("id");

		System.out.println("Chain ID : " + chainId);

		// GET Using Same ID
		given()

				.header("Authorization", "Bearer " + token)

				.pathParam("id", chainId)

				.when()

				.get("/users/{id}")

				.then()

				.statusCode(200)

				.log().all();

		// ================= JSON SCHEMA VALIDATION =================

		System.out.println("\n============== JSON SCHEMA VALIDATION ==============");

		// Schema Validation
		given()

				.header("Authorization", "Bearer " + token)

				.when()

				.get("/users/" + chainId)

				.then()

				.assertThat()

				.body(matchesJsonSchemaInClasspath("schema.json"))

				.log().all();

		// ================= PRINT HEADERS =================

		System.out.println("\n============== PRINT HEADERS ==============");

		// Print All Headers
		getResponse.getHeaders().forEach(System.out::println);

		// ================= PRINT COOKIES =================

		System.out.println("\n============== PRINT COOKIES ==============");

		// Print All Cookies
		getResponse.getCookies().forEach(

				(k, v) -> System.out.println(k + " : " + v));

		// ================= TEST COMPLETED =================

		System.out.println("\n============== TEST COMPLETED ==============");
	}
}