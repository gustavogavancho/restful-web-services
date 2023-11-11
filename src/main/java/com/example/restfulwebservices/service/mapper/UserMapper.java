package com.example.restfulwebservices.service.mapper;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PostMapper.class})
public interface UserMapper {
    UserDto userToUserDTO(User user);

    User userDTOToUser(UserDto userDTO);
}
