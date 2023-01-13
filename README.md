# { Client }
{ Client description }

## Install

### 1.Add maven dependency

```
<dependency>
    <groupId>com.byndyusoft.restclient</groupId>
    <artifactId>{Client}</artifactId>
    <version>{Veriosn}</version>
</dependency>
```

### 2. Add configuration properties
```
clients:
  {client}:
    readTimeout: 10s            # required
    connectionTimeout: 10s      # required
    connectionManager:
      defaultMaxPerRoute: 50    # required
      maxTotal: 50              # required
    baseUrl: localhost:8080     # required
```

### 3. Inject client
```
@Autowired
private {TemplateClient} client;
```

## Maintainers

- [@Byndyusoft/owners](https://github.com/orgs/Byndyusoft/teams/owners) <<github.maintain@byndyusoft.com>>
- [@Byndyusoft/team](https://github.com/orgs/Byndyusoft/teams/team)

## License

This repository is released under version 2.0 of the
[Apache License](https://www.apache.org/licenses/LICENSE-2.0).