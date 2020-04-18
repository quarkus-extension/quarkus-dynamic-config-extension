package com.github.previousdeveloper.dynamic.config;

import org.eclipse.microprofile.config.Config;

public class ConsulProvider implements DynamicConfigProvider {

    private ConsulClient consulClient;

    public ConsulProvider(Config config) {
        consulClient = new ConsulClient(config);
    }

    @Override
    public String get(String key) {
        return consulClient.get(key);
    }
}
