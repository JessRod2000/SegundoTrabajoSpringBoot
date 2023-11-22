package com.eeds.monolitica.proyect.services;

import com.eeds.monolitica.proyect.domain.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> listRoles();
    Optional<Rol> getRolById(Integer rolId);
    Rol saveRol(Rol rol);
    Rol updateRol(Integer id, Rol rol);
    void deleteRol(Integer id);
}