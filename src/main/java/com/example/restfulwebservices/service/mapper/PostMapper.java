package com.example.restfulwebservices.service.mapper;

import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.service.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);
}
