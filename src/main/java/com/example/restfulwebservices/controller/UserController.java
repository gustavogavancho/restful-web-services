package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.service.PostService;
import com.example.restfulwebservices.service.UserService;
import com.example.restfulwebservices.service.dto.PostDto;
import com.example.restfulwebservices.service.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService,
                          PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserDto> getUser(@PathVariable(name = "id") Integer id) {
        var user = userService.findById(id);
        EntityModel<UserDto> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user) {
        var userAdded = userService.add(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{id}/posts")
    public List<PostDto> getPostForUser(@PathVariable(name = "id") Integer id) {
        var user = userService.findById(id);

        return user.posts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<PostDto> addPostForUser(@PathVariable Integer id, @Valid @RequestBody PostDto postDto) {
        var user = userService.findById(id);

        postDto.setUser(user);

        var savedPost = postService.add(postDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
