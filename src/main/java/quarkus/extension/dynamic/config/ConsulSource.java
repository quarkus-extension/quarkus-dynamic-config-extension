package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConsulSource implements ConfigSource {
    ConsulClient consulClient;

    public ConsulSource() {

        consulClient = new ConsulClient();
    }

    @Override
    public Map<String, String> getProperties() {
        return new HashMap<>();
    }

    @Override
    public String getValue(String s) {
        String result = consulClient.get(s);
        return Objects.nonNull(result) ? result : null;
    }

    @Override
    public String getName() {
        return "consulsource";
    }

    @Override
    public int getOrdinal() {
        return 500;
    }
}
