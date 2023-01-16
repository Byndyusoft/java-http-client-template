package com.byndyusoft.java.service.client.configuration;

import java.time.Duration;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(prefix = "clients.service-name")
public class ClientProperties {
  @NotBlank
  private String rootUrl;
  @NotNull
  private Duration connectionTimeout;
  @NotNull
  private Duration readTimeout;
  @NestedConfigurationProperty
  private PoolingHttpClientConnectionManager connectionManager;
}
