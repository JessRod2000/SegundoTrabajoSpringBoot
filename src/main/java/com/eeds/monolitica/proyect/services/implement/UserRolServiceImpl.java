package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolUpdateDTO;
import com.eeds.monolitica.proyect.repositories.jdbc.UserRolJdbcRepository;
import com.eeds.monolitica.proyect.services.UserRolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolJdbcRepository userRolJdbcRepository;

    public UserRolServiceImpl(UserRolJdbcRepository userRolJdbcRepository) {
        this.userRolJdbcRepository = userRolJdbcRepository;
    }

    @Override
    public List<UserRolDTO> listUsersRoles() {
        return userRolJdbcRepository.listUsersRoles();
    }

    @Override
    public int save(UserRolDTO userRolDTO) {
        return userRolJdbcRepository.save(userRolDTO);
    }

    @Override
    public int updateStatusRol(Long userId, Integer rolId, UserRolUpdateDTO userRolUpdateDTO) {
        return userRolJdbcRepository.updateStatus(userId,rolId,userRolUpdateDTO);
    }

    @Override
    public void assignroles(Long userId, List<Integer> roles) {
        userRolJdbcRepository.assignroles(userId, roles);
    }

}
