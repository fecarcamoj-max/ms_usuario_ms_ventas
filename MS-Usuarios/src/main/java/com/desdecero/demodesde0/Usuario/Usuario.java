package com.desdecero.demodesde0.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Usuario será una tabla en la bds. Instancia de N objetos.
public class Usuario {

    @Id 
    private Integer id;
    @Column 
    private String nombre;
    @Column
    private String apellido;

    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}
