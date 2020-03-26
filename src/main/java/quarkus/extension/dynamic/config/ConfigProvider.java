package quarkus.extension.dynamic.config;

import java.util.Map;

public interface ConfigProvider {
    Map<String, String> get();

}

