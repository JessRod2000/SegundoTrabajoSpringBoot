package com.eeds.monolitica.proyect.dto;

import com.eeds.monolitica.proyect.domain.entities.UserDetail;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserNewDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private UserDetail userDetail;
}
