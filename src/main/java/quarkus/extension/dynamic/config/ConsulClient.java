package quarkus.extension.dynamic.config;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;

public class ConsulClient {
    KeyValueClient client;

    public ConsulClient() {
        client = Consul.builder()
                .build()
                .keyValueClient();
    }

    public String get(String key) {
        return client.getValueAsString(key.replace(".", "/")).orElse(null);
    }


}
