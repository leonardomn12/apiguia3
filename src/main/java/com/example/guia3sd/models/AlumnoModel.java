package com.example.guia3sd.models;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class AlumnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    private String nombre;
    private Integer edad;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEdad(Integer edad){
        this.edad = edad;
    }

    public Integer getEdad(){
        return edad;
    }

}