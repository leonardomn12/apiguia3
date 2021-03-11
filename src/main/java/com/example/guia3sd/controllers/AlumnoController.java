package com.example.guia3sd.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.guia3sd.models.AlumnoModel;
import com.example.guia3sd.services.AlumnoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    AlumnoServices alumnoServices;

    @GetMapping
    public ArrayList<AlumnoModel> obtenerAlumno(){
        return alumnoServices.obtenerAlumno();
    }

    @PostMapping
    public AlumnoModel guardarAlumno(@RequestBody AlumnoModel alumno){
        return this.alumnoServices.guardarUsuario(alumno);
    }

    @GetMapping( path = "/{id}")
    public Optional<AlumnoModel> obtenerAlumnoPorId(@PathVariable("id") Long id){
        return this.alumnoServices.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<AlumnoModel> obtenerAlumnoPorNombre(@RequestParam("nombre") String nombre){
        return this.alumnoServices.obtenerPorNombre(nombre);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.alumnoServices.eliminarAlumno(id);
        if(ok){
            return "Se eliminó el alumno con id" + id;
        }else{
            return "No puedo eliminar el alumno con id" + id;
        }
    }
}
