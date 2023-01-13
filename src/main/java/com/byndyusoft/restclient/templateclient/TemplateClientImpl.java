package com.byndyusoft.restclient.templateclient;

import com.byndyusoft.restclient.dto.TemplateRequestDto;
import com.byndyusoft.restclient.dto.TemplateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TemplateClientImpl implements TemplateClient {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public TemplateResponseDto getTemplateMethod(String uriParam) {
    return restTemplate.getForObject("/template/{uriParam}", TemplateResponseDto.class, uriParam);
  }

  @Override
  public TemplateResponseDto postTemplateMethod(final String uriParam, final TemplateRequestDto request) {
    return restTemplate.postForObject("/template/{uriParam}", request, TemplateResponseDto.class, uriParam);
  }
}
