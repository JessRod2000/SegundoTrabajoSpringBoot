package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.UserRepository;
import com.eeds.monolitica.proyect.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
