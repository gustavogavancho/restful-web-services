package com.example.restfulwebservices.exception;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@StackTrace
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
