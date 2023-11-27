package com.eeds.monolitica.proyect.repositories.data;

import com.eeds.monolitica.proyect.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByActiveOrderByUserNameAsc(Boolean active);
}
