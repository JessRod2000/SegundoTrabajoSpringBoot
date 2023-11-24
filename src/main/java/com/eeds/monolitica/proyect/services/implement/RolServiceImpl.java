package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.repositories.data.RolRepository;
import com.eeds.monolitica.proyect.services.RolService;
import com.eeds.monolitica.proyect.web.exception.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Optional<Rol> getRolById(Integer rolId) throws CustomNotFoundException {
        Optional<Rol> rolDB = rolRepository.findById(rolId);
        if(!rolDB.isPresent()){
            throw new CustomNotFoundException("El ROL con el ID :"+rolId+" NO EXISTE");
        }
        return rolRepository.findById(rolId);
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol updateRol(Integer id, Rol rol) {
        try {
            Rol rolDB = rolRepository.findById(id).orElseThrow(()->new NoSuchElementException("No se encontró el rol con ID: " + id));
            rolDB.setName(rol.getName());
            return rolRepository.save(rolDB);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el Rol con el ID : "+id,e);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor", e);
        }

    }

    @Override
    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
