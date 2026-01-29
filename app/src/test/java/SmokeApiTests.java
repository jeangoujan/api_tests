import static io.restassured.RestAssured.given;
// import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;



public class SmokeApiTests {
    // Arrange --- Act --- Assert
    String body = """
            {
                "id": 0,
                "username": "string",
                "firstName": "string",
                "lastName": "string",
                "email": "string",
                "password": "string",
                "phone": "string",
                "userStatus": 0
            }""";

    @Test
    void simpleTest(){
        given()
            .header("accept", "application/json")
            .header("Content-Type", "application/json")
            .baseUri("https://petstore.swagger.io/v2/")
        .when()
            .body(body)
            .post("user")
        .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("type", equalTo("unknown"))
            .body("message", notNullValue(String.class));

    }
}
