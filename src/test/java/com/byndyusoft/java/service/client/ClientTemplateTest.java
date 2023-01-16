package com.byndyusoft.java.service.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.byndyusoft.java.service.client.dto.TemplateRequestDto;
import com.byndyusoft.java.service.client.dto.TemplateResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class ClientTemplateTest {
  @InjectMocks
  private TemplateClientImpl client;
  @Mock
  private RestTemplate restTemplate;

  private static final String BASE_URI = "/template/{uriParam}";

  @Test
  void getTemplateMethod() {
    //given
    final String uriParam = "uriParam";
    final TemplateResponseDto expectedResponse = new TemplateResponseDto()
        .setCode("CODE")
        .setMessage("MESSAGE");

    when(restTemplate.getForObject(BASE_URI, TemplateResponseDto.class, uriParam)).thenReturn(expectedResponse);

    //when
    final TemplateResponseDto actualResponse = client.getTemplateMethod(uriParam);

    //then
    assertEquals(expectedResponse, actualResponse);
  }

  @Test
  void postTemplateMethod() {
    //given
    final String uriParam = "uriParam";
    final TemplateResponseDto expectedResponse = new TemplateResponseDto()
        .setCode("CODE")
        .setMessage("MESSAGE");
    final TemplateRequestDto request = new TemplateRequestDto()
        .setRequest("REQUEST");

    when(restTemplate.postForObject(BASE_URI, request, TemplateResponseDto.class, uriParam))
        .thenReturn(expectedResponse);

    //when
    final TemplateResponseDto actualResponse = client.postTemplateMethod(uriParam, request);

    //then
    assertEquals(expectedResponse, actualResponse);
  }

  @Test
  void getTemplateMethodThrowError() {
    //given
    final String uriParam = "uriParam";

    when(restTemplate.getForObject(BASE_URI, TemplateResponseDto.class, uriParam))
        .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

    //when
    final var actualError = assertThrows(HttpClientErrorException.class, () ->
        client.getTemplateMethod(uriParam));

    //then
    assertEquals(HttpStatus.BAD_REQUEST, actualError.getStatusCode());
  }
}
