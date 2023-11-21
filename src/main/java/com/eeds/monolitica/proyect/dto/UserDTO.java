package com.eeds.monolitica.proyect.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 8799612378674712000L;
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;
}
