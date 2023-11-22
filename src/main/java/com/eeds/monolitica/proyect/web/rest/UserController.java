package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<?>> listUsers(@RequestParam(required = false,defaultValue = "false") boolean detailed){
        if (detailed) {
            return ResponseEntity.ok().body(userService.listAllUsersDetailed());
        }else{
            return ResponseEntity.ok().body(userService.listAllUsers());
        }
    }
}
