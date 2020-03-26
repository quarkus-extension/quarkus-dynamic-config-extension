package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Map;
import java.util.Set;

public class CustomConfigSource implements ConfigSource {
    ConfigProvider configProvider = new JsonFileProvider();

    @Override
    public int getOrdinal() {
        return 1;
    }

    @Override
    public Map<String, String> getProperties() {
        return configProvider.get();
    }

    @Override
    public Set<String> getPropertyNames() {
        return getProperties().keySet();
    }

    @Override
    public String getValue(String key) {
        return getProperties().get(key);
    }

    @Override
    public String getName() {
        return "Custom Config Source: file:";
    }

}
