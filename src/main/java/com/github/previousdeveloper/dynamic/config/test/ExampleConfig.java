package com.github.previousdeveloper.dynamic.config.test;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ExampleConfig {

    @ConfigProperty(name = "email", defaultValue = "")
    Provider<String> email;

    @ConfigProperty(name = "info.age", defaultValue = "")
    Provider<String> age;

    public Provider<String> getEmail() {
        return email;
    }

    public void setEmail(Provider<String> email) {
        this.email = email;
    }

    public Provider<String> getAge() {
        return age;
    }

    public void setAge(Provider<String> age) {
        this.age = age;
    }
}