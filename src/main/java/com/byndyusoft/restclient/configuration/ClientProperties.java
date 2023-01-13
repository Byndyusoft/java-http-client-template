package com.byndyusoft.restclient.configuration;

import java.time.Duration;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(prefix = "clients.templateClient")
public class ClientProperties {
  @NestedConfigurationProperty
  private PoolingHttpClientConnectionManager connectionManager;
  private String baseUrl;
  @NotNull
  private Duration connectionTimeout;
  @NotNull
  private Duration readTimeout;
}
