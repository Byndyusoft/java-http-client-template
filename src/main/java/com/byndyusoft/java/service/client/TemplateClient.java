package com.byndyusoft.java.service.client;

import com.byndyusoft.java.service.client.dto.TemplateRequestDto;
import com.byndyusoft.java.service.client.dto.TemplateResponseDto;
import org.springframework.web.client.RestClientException;

public interface TemplateClient {
  TemplateResponseDto getTemplateMethod(String uriParam) throws RestClientException;
  TemplateResponseDto postTemplateMethod(String uriParam, TemplateRequestDto request) throws RestClientException;
}
