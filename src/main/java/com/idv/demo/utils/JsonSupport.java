package com.idv.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonSupport {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonSupport() {
    }

    public static String objectToJson(Object obj) {
        if (obj == null) {
            return null;
        }

        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error occurred while serializing object to JSON: " + obj, e);
        }
    }
}
