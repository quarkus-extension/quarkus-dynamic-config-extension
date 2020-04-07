# Quarkus Dynamic Config Extension

- File Based Changes:

Quarkus dynamic extension watches config file and changes value at runtime

- Consul Based Changes:


### Dependency
- maven:

```xml
<dependency>
      <groupId>quarkus.extension</groupId>
      <artifactId>dynamic-config</artifactId>
      <version>0.0.1</version>
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
