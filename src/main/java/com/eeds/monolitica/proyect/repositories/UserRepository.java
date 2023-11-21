package com.eeds.monolitica.proyect.repositories;

import com.eeds.monolitica.proyect.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
