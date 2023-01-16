package com.byndyusoft.java.service.client;

import com.byndyusoft.java.service.client.dto.TemplateRequestDto;
import com.byndyusoft.java.service.client.dto.TemplateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TemplateClientImpl implements TemplateClient {
  private final RestTemplate serviceClientRestTemplate;

  @Override
  public TemplateResponseDto getTemplateMethod(final String uriParam) {
    return serviceClientRestTemplate.getForObject("/template/{uriParam}", TemplateResponseDto.class, uriParam);
  }

  @Override
  public TemplateResponseDto postTemplateMethod(final String uriParam, final TemplateRequestDto request) {
    return serviceClientRestTemplate.postForObject("/template/{uriParam}", request, TemplateResponseDto.class, uriParam);
  }
}
