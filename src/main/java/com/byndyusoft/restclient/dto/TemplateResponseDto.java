package com.byndyusoft.restclient.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TemplateResponseDto {
  private String code;
  private String message;
}
