package com.example.restfulwebservices.service.impl;

import com.example.restfulwebservices.repository.PostRepository;
import com.example.restfulwebservices.service.PostService;
import com.example.restfulwebservices.service.dto.PostDto;
import com.example.restfulwebservices.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                          PostMapper postMapper){
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto add(PostDto postDto) {
        var post = postMapper.postDtoToPost(postDto);
        var savedPost = postRepository.save(post);
        return postMapper.postToPostDto(savedPost);
    }
}
