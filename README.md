# { service-name } rest api client
this is api client for { service-name }

## Install

### 1.Add maven dependency
```
<dependency>
    <groupId>com.byndyusoft.java</groupId>
    <artifactId>service-client</artifactId>
    <version>0.0.1</version>
</dependency>
```

### 2. Add configuration properties
```
clients:
  service-name:
    rootUrl: localhost:8080     # required
    readTimeout: 10s            # required
    connectionTimeout: 10s      # required
    connectionManager:
      defaultMaxPerRoute: 50    # required
      maxTotal: 50              # required
```

### 3. Inject client
```
@Autowired
private TemplateClient client;
```

## Maintainers

- [@Byndyusoft/owners](https://github.com/orgs/Byndyusoft/teams/owners) <<github.maintain@byndyusoft.com>>
- [@Byndyusoft/team](https://github.com/orgs/Byndyusoft/teams/team)
- [@Byndyusoft/java-admins](https://github.com/orgs/Byndyusoft/teams/java-admins)

## License

This repository is released under version 2.0 of the
[Apache License](https://www.apache.org/licenses/LICENSE-2.0).