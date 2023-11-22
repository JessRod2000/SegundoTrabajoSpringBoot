package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    List<UserDetailDTO> listAllUsersDetailed();
}
