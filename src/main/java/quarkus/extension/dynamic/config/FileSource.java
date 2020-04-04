package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Map;
import java.util.Set;

public class FileSource implements ConfigSource {
    private Config config;
    DynamicConfigProvider dynamicConfigProvider = null;

    public FileSource() {
        config = createConfig();
    }

    @Override
    public int getOrdinal() {
        return 450;
    }

    @Override
    public Map<String, String> getProperties() {
        initFileProvider();

        return dynamicConfigProvider.get();
    }

    @Override
    public Set<String> getPropertyNames() {
        return getProperties().keySet();
    }

    @Override
    public String getValue(String key) {
        initFileProvider();
        return getProperties().get(key);
    }

    @Override
    public String getName() {
        return "CustomConfigSource";
    }

    private void initFileProvider() {
        if (dynamicConfigProvider == null) {
            dynamicConfigProvider = new JsonFileProviderDynamic(config);
        }
    }

    private Config createConfig() {
        return ConfigProviderResolver.instance()
                .getBuilder()
                .addDefaultSources()
                .build();
    }
}
