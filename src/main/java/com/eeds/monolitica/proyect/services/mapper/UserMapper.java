package com.eeds.monolitica.proyect.services.mapper;

import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.domain.entities.UserDetail;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;
import org.springframework.stereotype.Component;

@Component
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
        user.setActive(Boolean.TRUE);

        return user;
    }
    public User toEntityCreate(UserNewDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setActive(Boolean.TRUE);

        return user;
    }

    public UserDetailDTO toDtoDetailed(User user){
        UserDetailDTO userDTO=new UserDetailDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedAt(user.getCreatedAt());

        UserDetail userDetail = user.getUserDetail();
        if (userDetail!=null){
            userDTO.setUserDetailId(userDetail.getId());
            userDTO.setFirstName(userDetail.getFirstName());
            userDTO.setLastName(userDetail.getLastName());
            userDTO.setAge(userDetail.getAge());
            userDTO.setBirthDay(userDetail.getBirthDay());
        }
        return userDTO;
    }
    public UserNewDTO toDtoNew(User user){
        UserNewDTO userDTO=new UserNewDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedAt(user.getCreatedAt());

        UserDetail userDetail = user.getUserDetail();
        if (userDetail!=null){
            userDTO.setUserDetail(userDetail);
        }
        return userDTO;
    }
}
