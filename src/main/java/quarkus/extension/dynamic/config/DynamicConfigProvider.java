package quarkus.extension.dynamic.config;

import java.util.Map;

public interface DynamicConfigProvider {
    Map<String, String> get();
}

