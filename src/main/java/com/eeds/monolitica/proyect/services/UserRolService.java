package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolUpdateDTO;

import java.util.List;

public interface UserRolService {
    List<UserRolDTO> listUsersRoles();
    //List<UserRolDetailDTO> listUsersRolesDetailed();
    int save(UserRolDTO userRolDTO);
    int updateStatusRol(Long userId, Integer rolId, UserRolUpdateDTO userRolUpdateDTO);
}
