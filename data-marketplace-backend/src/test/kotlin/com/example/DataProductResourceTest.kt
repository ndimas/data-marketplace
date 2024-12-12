import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test
import io.restassured.RestAssured.given
import jakarta.ws.rs.core.MediaType
import org.hamcrest.CoreMatchers.`is`

@QuarkusTest
class DataProductResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .`when`().get("/data-product")
            .then()
            .statusCode(200)
            .body(`is`("Hello, World!")) // Adjust the expected response body as needed
    }
}