package com.eeds.monolitica.proyect.repositories.jdbc;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolUpdateDTO;

import java.util.List;

public interface UserRolJdbcRepository {
    List<UserRolDTO> listUsersRoles();
    int save(UserRolDTO userRolDTO);

    int updateStatus(Long userId, Integer rolId, UserRolUpdateDTO userRolUpdateDTO);
}
