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
}