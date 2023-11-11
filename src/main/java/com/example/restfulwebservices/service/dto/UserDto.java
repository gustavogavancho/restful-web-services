package com.example.restfulwebservices.service.dto;

import java.time.LocalDate;

public record UserDto(Integer id, String name, LocalDate birthDate) { }
