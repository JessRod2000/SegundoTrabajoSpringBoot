package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.repositories.RolRepository;
import com.eeds.monolitica.proyect.services.RolService;

public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
}
