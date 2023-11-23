package com.eeds.monolitica.proyect.dto;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolUpdateDTO {
    private Boolean active;
}
