package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.UserDetailRepository;
import com.eeds.monolitica.proyect.services.UserDetailService;

public class UserDetailImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }
}
