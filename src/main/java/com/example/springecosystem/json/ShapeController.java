package com.example.springecosystem.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shape")
public class ShapeController {

    @PostMapping(value = "/new", consumes = {"application/json"})
    public String newShape(@RequestBody Shape shape) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String serializedShape = objectMapper.writeValueAsString(shape);
        return serializedShape;
    }
}
