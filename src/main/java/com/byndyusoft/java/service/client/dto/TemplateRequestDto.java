package com.byndyusoft.java.service.client.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TemplateRequestDto {
  @NotBlank
  private String request;
}
