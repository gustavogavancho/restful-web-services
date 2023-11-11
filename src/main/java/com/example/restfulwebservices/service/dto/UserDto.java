package com.example.restfulwebservices.service.dto;

import java.time.LocalDate;
import java.util.List;

public record UserDto(Integer id, String name, LocalDate birthDate, List<PostDto> posts) { }
