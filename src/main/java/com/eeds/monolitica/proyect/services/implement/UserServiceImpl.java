package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.repositories.UserRepository;
import com.eeds.monolitica.proyect.services.UserService;
import com.eeds.monolitica.proyect.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> listAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailDTO> listAllUsersDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDtoDetailed).collect(Collectors.toList());
    }
}
