# Quarkus Dynamic Config Extension

[![Maven Central](https://img.shields.io/maven-central/v/com.github.quarkus-extension/dynamic-config?color=green&style=plastic)](https://search.maven.org/artifact/com.github.quarkus-extension/dynamic-config)
![Issues](https://img.shields.io/github/issues/quarkus-extension/quarkus-dynamic-config-extension)
![Stars](https://img.shields.io/github/stars/quarkus-extension/quarkus-dynamic-config-extension)


- File Based Changes:

Quarkus dynamic extension watches config file and changes value at runtime

- Consul Based Changes:


### Dependency
- maven:

```xml
<dependency>
      <groupId>com.github.quarkus-extension</groupId>
      <artifactId>dynamic-config</artifactId>
      <version>0.0.3</version>
</dependency>
```

### Listen File Based Changes
```xml
export CONFIG_FILE_PATH= "/deneme.json"

```

### Listen Consul Key Value Changes
```xml
export CONSUL_HTTP_ADDR= "http://localhost:8500"

```
