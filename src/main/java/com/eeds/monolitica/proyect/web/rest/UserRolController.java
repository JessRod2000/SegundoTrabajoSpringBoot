package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.dto.UserRolDTO;
import com.eeds.monolitica.proyect.dto.UserRolUpdateDTO;
import com.eeds.monolitica.proyect.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/user-rol")
@CrossOrigin(origins = "http://localhost:5173")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }
    @GetMapping
    public ResponseEntity<List<UserRolDTO>> listAllUserRol(){
        return ResponseEntity.ok()
                .body(userRolService.listUsersRoles());
    }
    @PostMapping
    public ResponseEntity<Void> createUserRol(@RequestBody final UserRolDTO userRolDTO) throws URISyntaxException{
        userRolService.save(userRolDTO);
        return ResponseEntity.created(null).build();
    }
    @PatchMapping("/{userId}/roles/{rolId}")
    public ResponseEntity<Void> updateStatus(@PathVariable final Long userId,
                                             @PathVariable final Integer rolId,
                                             @RequestBody final UserRolUpdateDTO userRolUpdateDTO) throws URISyntaxException{
        userRolService.updateStatusRol(userId,rolId,userRolUpdateDTO);
        return ResponseEntity.created(null).build();
    }
    @PostMapping("/{userId}/assign-roles")
    public ResponseEntity<Void> assignRolesToUser(@PathVariable final Long userId,
                                                  @RequestBody List<Integer> roles){
        userRolService.assignroles(userId, roles);
        return ResponseEntity.created(null).build();
    }
}
