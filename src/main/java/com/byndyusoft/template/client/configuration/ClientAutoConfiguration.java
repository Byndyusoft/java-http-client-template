package com.byndyusoft.template.client.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@ComponentScan(basePackages = {"com.byndyusoft"})
@EnableAutoConfiguration
@EnableConfigurationProperties(ClientProperties.class)
public class ClientAutoConfiguration {
  private final RestTemplateBuilder restTemplateBuilder;

  @Bean
  public RestTemplate restTemplate(final ClientProperties clientProperties) {
    return buildRestTemplate(clientProperties);
  }

  public ClientAutoConfiguration(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplateBuilder = restTemplateBuilder;
  }

  private RestTemplate buildRestTemplate(final ClientProperties clientProperties) {
    final HttpClient httpClient = HttpClientBuilder.create()
        .setConnectionManager(clientProperties.getConnectionManager())
        .build();

    final ClientHttpRequestFactory requestFactory =
        new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));

    final DefaultUriBuilderFactory uriTemplateHandler =
        new DefaultUriBuilderFactory(clientProperties.getBaseUrl());

    return restTemplateBuilder
        .requestFactory(() -> requestFactory)
        .uriTemplateHandler(uriTemplateHandler)
        .setConnectTimeout(clientProperties.getConnectionTimeout())
        .setReadTimeout(clientProperties.getReadTimeout())
        .build();
  }
}
