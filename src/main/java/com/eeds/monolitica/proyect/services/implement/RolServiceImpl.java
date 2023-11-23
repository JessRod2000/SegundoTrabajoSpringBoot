package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.repositories.data.RolRepository;
import com.eeds.monolitica.proyect.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> listRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> getRolById(Integer rolId) {
        return rolRepository.findById(rolId);
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol updateRol(Integer id, Rol rol) {
        Rol rolDB = rolRepository.findById(id).orElseThrow(()->new NoSuchElementException("No se encontró el rol con ID: " + id));
        rolDB.setName(rol.getName());
        return rolRepository.save(rolDB);
    }

    @Override
    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
