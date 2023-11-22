package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolDetailDTO;
import com.eeds.monolitica.proyect.repositories.UserRolRepository;
import com.eeds.monolitica.proyect.services.UserRolService;
import com.eeds.monolitica.proyect.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRolImpl implements UserRolService {
    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;

    public UserRolImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> listUsersRoles() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRolDetailDTO> listUsersRolesDetailed() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDoDetailed).collect(Collectors.toList());
    }
}
