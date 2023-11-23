package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.data.UserDetailRepository;
import com.eeds.monolitica.proyect.services.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }
}
