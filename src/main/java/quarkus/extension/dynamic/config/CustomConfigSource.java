package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomConfigSource implements ConfigSource {
    private Config config;
    private DynamicConfigProvider providerSelector;

    public CustomConfigSource() {
        config = createConfig();
        providerSelector = new ProviderSelector(config).getProvider();

    }

    @Override
    public int getOrdinal() {
        return 450;
    }

    @Override
    public Set<String> getPropertyNames() {
        return getProperties().keySet();
    }

    @Override
    public Map<String, String> getProperties() {
        return new HashMap<>();
    }

    @Override
    public String getValue(String key) {
        return providerSelector.get(key);
    }

    @Override
    public String getName() {
        return "CustomConfigSource";
    }

    private Config createConfig() {
        return ConfigProviderResolver.instance()
                .getBuilder()
                .addDefaultSources()
                .build();
    }
}
