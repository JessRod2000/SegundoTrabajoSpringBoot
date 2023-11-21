package com.eeds.monolitica.proyect.services.mapper;

import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;

public class UserMapper implements CustomMapper<UserDTO, User>{

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setCreatedAt(userDTO.getCreatedAt());

        return user;
    }
}
