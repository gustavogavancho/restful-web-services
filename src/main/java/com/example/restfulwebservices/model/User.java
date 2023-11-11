package com.example.restfulwebservices.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, message = "Name should have at least 2 chars")
    private String name;

    @Past(message = "Date should be in the past")
    @NotNull(message = "Date should not be null")
    private LocalDate birthData;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthData=" + birthData +
                '}';
    }
}
