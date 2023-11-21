package com.eeds.monolitica.proyect.repositories;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
