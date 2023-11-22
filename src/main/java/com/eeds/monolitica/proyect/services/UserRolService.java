package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolDetailDTO;

import java.util.List;

public interface UserRolService {
    List<UserRolDTO> listUsersRoles();
    List<UserRolDetailDTO> listUsersRolesDetailed();
}
