package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;
import com.eeds.monolitica.proyect.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserNewDTO userDTO) throws URISyntaxException{
        UserDTO userDB = userService.save(userDTO);
        return ResponseEntity.created(new URI("/v1/users/"+userDB.getId())).body(userDB);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable final Long userId){
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
