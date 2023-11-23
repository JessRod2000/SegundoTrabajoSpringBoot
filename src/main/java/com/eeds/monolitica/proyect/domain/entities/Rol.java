package com.eeds.monolitica.proyect.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
//import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")
    private Integer id;
    private String name;

    public Rol(String name) {
        this.name = name;
    }

    public Rol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
