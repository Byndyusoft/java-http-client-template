package com.byndyusoft.service.client;

import com.byndyusoft.service.client.dto.TemplateRequestDto;
import com.byndyusoft.service.client.dto.TemplateResponseDto;
import org.springframework.web.client.RestClientException;

public interface TemplateClient {
  TemplateResponseDto getTemplateMethod(String uriParam) throws RestClientException;
  TemplateResponseDto postTemplateMethod(String uriParam, TemplateRequestDto request) throws RestClientException;
}
