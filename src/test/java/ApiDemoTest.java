import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Test Cases for check API on localhost
 */
public class ApiDemoTest {
    @BeforeAll
    @DisplayName("Authentication")
    public static void setUpAuth() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        authentication = authScheme;
    }

    @BeforeAll
    public static void setUpErrorLogging() {
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Get locations of city")
    public void shouldGetLocationsWhenPopulateDb() {
        when()
                .get("/api/locations")
                .then()
                .statusCode(200)
                .body(
                        "size()", is(10),
                        "[0].city", is("West Hopefort"),
                        "[1].id", not(isEmptyOrNullString())
                );
    }

    @Test
    @DisplayName("Create new country if it doesn't exist")
    public void shouldCreateCountryWhenUnique() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        " \"countryName\": \"MI\"\n" +
                        "}")
                .when()
                .post("/api/countries")
                .then()
                .statusCode(201)
                .body("id", not(empty()));
    }

    @Test
    @DisplayName("Update name of country")
    public void shouldUpdateCountry() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        " \"id\": \"3\",\n" +
                        " \"countryName\": \"FE\"\n" +
                        "}")
                .when()
                .put("/api/countries/3")
                .then()
                .statusCode(200)
                .body("id", is(3),
                        "countryName", is("FE")
                );
    }

    @Test
    @DisplayName("Delete country")
    public void shouldDeleteCountry() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        " \"id\": \"3\",\n" +
                        " \"countryName\": \"FE\"\n" +
                        "}")
                .when()
                .delete("api/countries/3")
                .then()
                .statusCode(204)
                .body(isEmptyOrNullString());
    }
}
