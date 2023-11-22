package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/user-rol")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }
    @GetMapping
    public ResponseEntity<List<?>> listUsersRoles(@RequestParam(required = false,defaultValue = "false")boolean detailed){
        if (detailed) {
            return ResponseEntity.ok().body(userRolService.listUsersRolesDetailed());
        }else {
            return ResponseEntity.ok().body(userRolService.listUsersRoles());
        }
    }
}
