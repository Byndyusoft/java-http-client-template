package com.byndyusoft.java.service.client.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TemplateResponseDto {
  @NotBlank
  private String code;
  @NotNull
  private String message;
}
