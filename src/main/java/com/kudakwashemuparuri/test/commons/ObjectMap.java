package com.kudakwashemuparuri.test.commons;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kudakwashemuparuri.test.exception.InvalidRequestException;

public class ObjectMap {

    public static <T, U> U mapToEntity(T input, Class<U> mappedClass) {
        return mapToDTO(input, mappedClass);
    }

    public static <T, U> U mapToDTO(T input, Class<U> mappedClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(input, mappedClass);
    }

    public static <T, U> U updateEntity(U mappedClass, T input) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDefaultSetterInfo(JsonSetter.Value.forValueNulls(Nulls.SKIP));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.updateValue(mappedClass, input);

        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new InvalidRequestException("Fail to map objects");
        }
    }
}