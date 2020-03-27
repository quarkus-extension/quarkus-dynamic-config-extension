package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class Config {

    @ConfigProperty(name = "email", defaultValue = "")
    Provider<String> email;

    @ConfigProperty(name = "info.age", defaultValue = "")
    Provider<String> age;
}