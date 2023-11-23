package com.eeds.monolitica.proyect.web.exception;

public class RolNotFoundException extends RuntimeException{
    public RolNotFoundException(Integer id) {
        super("No existe un registro de un Rol con el ID: "+id);
    }
}
