package com.eeds.monolitica.proyect.repositories.data;

import com.eeds.monolitica.proyect.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
