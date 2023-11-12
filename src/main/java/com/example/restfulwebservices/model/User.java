package com.example.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "local_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3, message = "Name should have at least 2 chars")
    @Column(name = "name")
    private String name;

    @Past(message = "Date should be in the past")
    @NotNull(message = "Date should not be null")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthData=" + birthDate +
                '}';
    }
}
