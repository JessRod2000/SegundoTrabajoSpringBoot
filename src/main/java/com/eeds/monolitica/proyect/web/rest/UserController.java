package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;
import com.eeds.monolitica.proyect.services.UserService;
import com.eeds.monolitica.proyect.web.exception.CustomNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

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
    @GetMapping("/{userId}")
    public ResponseEntity<?> getRolById(@PathVariable final Long userId) throws CustomNotFoundException {
        return ResponseEntity.ok()
                .body(userService.getUserById(userId).get());
    }
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody final UserNewDTO userDTO) throws URISyntaxException{
        UserDTO userDB = userService.save(userDTO);
        return ResponseEntity.created(new URI("/v1/users/"+userDB.getId())).body(userDB);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> logicalDelete(@PathVariable final Long userId){
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDetailDTO> editUser(@RequestBody final UserDetailDTO userDto,
                                            @PathVariable final Long userId) throws CustomNotFoundException{
        if (userDto.getId() == null) {
            throw new IllegalArgumentException("Invalid course id, null value");
        }
        if (!Objects.equals(userDto.getId(), userId)) {
            throw new IllegalArgumentException("Invalid id: "+userId);
        }
        return ResponseEntity
                .ok()
                .body(this.userService.updateUser(userId,userDto));
    }
}
