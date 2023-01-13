package com.byndyusoft.template.client;

import com.byndyusoft.template.client.dto.TemplateRequestDto;
import com.byndyusoft.template.client.dto.TemplateResponseDto;

public interface TemplateClient {
  TemplateResponseDto getTemplateMethod(String uriParam);
  TemplateResponseDto postTemplateMethod(String uriParam, TemplateRequestDto request);
}
