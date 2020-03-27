import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ConfigTestIT {

    @Inject
    private ExampleConfig exampleConfig;

    @Test
    public void it_should_get_age() {
        String s = exampleConfig.age.get();
        Assertions.assertEquals(s, "28");
    }

}
