package com.eeds.monolitica.proyect.services.mapper;

import com.eeds.monolitica.proyect.domain.entities.UserRol;
import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol> {

    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO userRolDTO = new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        //userRolDTO.setUser(userRol.getUser());
        //userRolDTO.setRol(userRol.getRol());
        return userRolDTO;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol = new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        //userRol.setUser(userRolDTO.getUser());
        //userRol.setRol(userRolDTO.getRol());
        return userRol;
    }

    public UserRolDetailDTO toDoDetailed(UserRol userRol){
        UserRolDetailDTO userRolDTO = new UserRolDetailDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        userRolDTO.setUserName(userRol.getUser().getUserName());
        userRolDTO.setEmail(userRol.getUser().getEmail());
        userRolDTO.setNameRol(userRol.getRol().getName());
        return userRolDTO;
    }
}
