package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.UserRepository;
import com.eeds.monolitica.proyect.services.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
