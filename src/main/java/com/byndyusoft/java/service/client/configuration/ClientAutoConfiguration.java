package com.byndyusoft.java.service.client.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
import org.zalando.logbook.httpclient.LogbookHttpRequestInterceptor;
import org.zalando.logbook.httpclient.LogbookHttpResponseInterceptor;

@Configuration
@ComponentScan(basePackages = {"com.byndyusoft.java.service.client"})
@RequiredArgsConstructor
@EnableConfigurationProperties(ClientProperties.class)
public class ClientAutoConfiguration {
  private final RestTemplateBuilder restTemplateBuilder;
  private final LogbookHttpRequestInterceptor logbookHttpRequestInterceptor;
  private final LogbookHttpResponseInterceptor logbookHttpResponseInterceptor;

  @Bean
  public RestTemplate serviceClientRestTemplate(final ClientProperties clientProperties) {
    return buildRestTemplate(clientProperties);
  }

  private RestTemplate buildRestTemplate(final ClientProperties clientProperties) {
    final HttpClient httpClient = HttpClientBuilder.create()
        .setConnectionManager(clientProperties.getConnectionManager())
        .addInterceptorFirst(logbookHttpRequestInterceptor)
        .addInterceptorLast(logbookHttpResponseInterceptor)
        .build();

    final ClientHttpRequestFactory requestFactory =
        new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));

    final DefaultUriBuilderFactory uriTemplateHandler =
        new DefaultUriBuilderFactory(clientProperties.getRootUrl());

    return restTemplateBuilder
        .requestFactory(() -> requestFactory)
        .uriTemplateHandler(uriTemplateHandler)
        .setConnectTimeout(clientProperties.getConnectionTimeout())
        .setReadTimeout(clientProperties.getReadTimeout())
        .build();
  }
}
