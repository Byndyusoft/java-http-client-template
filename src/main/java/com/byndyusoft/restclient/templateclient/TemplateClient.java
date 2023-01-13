package com.byndyusoft.restclient.templateclient;

import com.byndyusoft.restclient.dto.TemplateRequestDto;
import com.byndyusoft.restclient.dto.TemplateResponseDto;

public interface TemplateClient {
  TemplateResponseDto getTemplateMethod(String uriParam);
  TemplateResponseDto postTemplateMethod(String uriParam, TemplateRequestDto request);
}
