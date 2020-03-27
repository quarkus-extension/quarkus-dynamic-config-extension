package quarkus.extension.dynamic.config.test;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/config")
public class TestResource {

    @Inject
    ExampleConfig exampleConfig;

    @GET
    @Path("age")
    public String getAge() {
        String age = null;
        try {
            age = exampleConfig.age.get();
        } catch (Exception e) {
        }
        return age;
    }
}
