package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.UserRolRepository;
import com.eeds.monolitica.proyect.services.UserRolService;

public class UserRolImpl implements UserRolService {
    private final UserRolRepository userRolRepository;

    public UserRolImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }
}
