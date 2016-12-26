package com.illicis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;

public class ObjectMapperImpl implements com.mashape.unirest.http.ObjectMapper {

  ObjectMapper objectMapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

  @Override
  public <T> T readValue(String value, Class<T> valueType) {
    try {
      return objectMapper.readValue(value, valueType);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public String writeValue(Object value) {
    try {
      return objectMapper.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return null;
  }
}
