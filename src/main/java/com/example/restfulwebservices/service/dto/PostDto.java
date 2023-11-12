package com.example.restfulwebservices.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private Integer id;
    private String description;
    @JsonIgnore
    private UserDto user;
}