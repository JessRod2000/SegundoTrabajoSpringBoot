package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;
import com.eeds.monolitica.proyect.web.exception.CustomNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> listAllUsers();
    List<UserDetailDTO> listAllUsersDetailed();
    UserDTO save(UserNewDTO userDTO);
    void delete(Long userid);
    UserDetailDTO updateUser(Long id, UserDetailDTO userDTO);
    Optional<UserDetailDTO> getUserById(Long userId) throws CustomNotFoundException;
}
