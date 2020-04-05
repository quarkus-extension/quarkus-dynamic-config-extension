package quarkus.extension.dynamic.config;

public interface DynamicConfigProvider {
    String get(String key);
}

