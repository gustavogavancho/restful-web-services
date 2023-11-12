package com.example.restfulwebservices.service.mapper;

import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.service.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "user", source = "user")
    PostDto postToPostDto(Post post);

    @Mapping(target = "user", source = "user")
    Post postDtoToPost(PostDto postDto);
}
