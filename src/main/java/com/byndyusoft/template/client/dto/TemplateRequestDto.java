package com.byndyusoft.template.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TemplateRequestDto {
  private String request;
}
