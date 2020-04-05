package quarkus.extension.dynamic.config;

import org.eclipse.microprofile.config.Config;

import java.util.Objects;

public class ProviderSelector {

    private Config config;

    public ProviderSelector(Config config) {
        this.config = config;
    }

    public DynamicConfigProvider getProvider() {
        if (isFilePathExist(config)) {
            return new JsonFileProvider(config);
        }
        if (isConsulConfigExist(config)) {
            return new ConsulProvider(config);
        }

        return new DefaultProvider();
    }

    private boolean isFilePathExist(Config config) {
        return Objects.nonNull(config.getOptionalValue("CONFIG_FILE_PATH", String.class).orElse(null));
    }

    private boolean isConsulConfigExist(Config config) {
        return Objects.nonNull(config.getOptionalValue("CONSUL_HTTP_ADDR", String.class).orElse(null));
    }
}
