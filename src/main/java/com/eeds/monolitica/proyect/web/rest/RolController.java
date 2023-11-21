package com.eeds.monolitica.proyect.web.rest;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> listRoles(){
        return ResponseEntity.ok().body(rolService.listRoles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable final Integer id){
        return ResponseEntity.ok()
                .body(rolService.getRolById(id).orElseThrow(()->new IllegalArgumentException("Rol no encontrado con el id: "+id)));
    }

    @PostMapping
    public ResponseEntity<Rol> saveRol(@RequestBody final Rol rol) throws URISyntaxException {
        Rol rolDB = rolService.saveRol(rol);
        return ResponseEntity.created(new URI("/v1/roles/" + rolDB.getId()))
                .body(rolDB);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable final Integer id,
                                         @RequestBody final Rol updateRol){
        return ResponseEntity.ok().body(rolService.updateRol(id, updateRol));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable final Integer id){
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
