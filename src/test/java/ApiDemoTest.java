import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.jupiter.api.*;

import java.sql.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test Cases for check API on localhost
 */
public class ApiDemoTest {

    private Connection connection;
    Long id = null;

    @BeforeEach
    @DisplayName("Set up connection to DB")
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/app-db",
                "app-db-admin",
                "P@ssw0rd"
        );
        id = newId();
    }

    public Long newId() throws SQLException {
        PreparedStatement insert = connection.prepareStatement(
                "INSERT INTO country(country_name) VALUES(?)",
                Statement.RETURN_GENERATED_KEYS
        );
        insert.setString(1, "99");
        insert.executeUpdate();
        ResultSet result = insert.getGeneratedKeys();
        result.next();
        return result.getLong(1);
    }

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

    @AfterEach
    @DisplayName("Disconnection from DB")
    public void disconnect() throws SQLException {
        if (id != null) deleteData(id);
        id = null;
        connection.close();
    }

    private void deleteData(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement("DELETE from country where id = ?");
        delete.setLong(1, id);
        delete.executeUpdate();
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
    @DisplayName("Get country")
    public void shouldGetCountry() {
        when()
                .get("/api/countries")
                .then()
                .statusCode(200)
                .body("", hasItem(hasEntry("countryName", "99"))
                );
    }

    @Test
    @DisplayName("Create new country if it doesn't exist")
    public void shouldCreateCountryWhenUnique() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        " \"countryName\": \"99\"\n" +
                        "}")
                .when()
                .post("/api/countries")
                .then()
                .statusCode(201)
                .body("id", not(empty()));
    }

    @Test
    @DisplayName("Update name of country")
    public void shouldUpdateCountry() throws SQLException {
        String countryName = "PP";
        given()
                .contentType("application/json")
                .body(String.format("{\n" +
                        " \"id\": %d,\n" +
                        " \"countryName\": \"%s\"\n" +
                        "}", id, countryName))
                .when()
                .put(String.format("/api/countries/%d", id))
                .then()
                .statusCode(200);
        assertThat(selectId(id), equalTo(countryName));
    }

    private String selectId(Long id) throws SQLException {
        PreparedStatement select = connection.prepareStatement("SELECT * from country where id = ?");
        select.setLong(1, id);
        ResultSet result = select.executeQuery();
        if (result.next()) return result.getString(2);
        else return null;
    }

    @Test
    @DisplayName("Delete country")
    public void shouldDeleteCountry() {
        given()
                .when()
                .delete("api/countries/" + id)
                .then()
                .statusCode(204)
                .body(isEmptyOrNullString());
    }
}
