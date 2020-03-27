import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

@QuarkusTest()
public class ConfigTestIT {

    @Test
    public void it_should_get_config() {
        RestAssured.given().when().get("/config/age").then().body(is("28"));
    }
}
