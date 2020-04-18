package com.github.previousdeveloper.dynamic.config;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import org.eclipse.microprofile.config.Config;

public class ConsulClient {
    KeyValueClient client;

    public ConsulClient(Config config) {
        client = Consul.builder()
                .build()
                .keyValueClient();
    }

    public String get(String key) {
        return client.getValueAsString(key.replace(".", "/")).orElse(null);
    }
}
