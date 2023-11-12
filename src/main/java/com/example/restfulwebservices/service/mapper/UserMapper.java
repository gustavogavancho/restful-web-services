package com.example.restfulwebservices.service.mapper;

import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.dto.PostDto;
import com.example.restfulwebservices.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "posts", source = "posts")
    UserDto userToUserDTO(User user);

    @Mapping(target = "user", ignore = true)
    PostDto toPostDto(Post post);

    User userDTOToUser(UserDto userDTO);
}
