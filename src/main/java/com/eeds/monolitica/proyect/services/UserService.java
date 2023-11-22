package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    List<UserDetailDTO> listAllUsersDetailed();
    UserDTO save(UserNewDTO userDTO);
    void delete(Long userid);
    UserDTO updateRol(Long id, UserNewDTO userDTO);
}
