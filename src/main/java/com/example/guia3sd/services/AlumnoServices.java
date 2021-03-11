package com.example.guia3sd.services;

import com.example.guia3sd.models.AlumnoModel;
import com.example.guia3sd.repositories.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class AlumnoServices {
    @Autowired
    AlumnoRepository alumnoRepository;

    public ArrayList<AlumnoModel> obtenerAlumno(){
        return(ArrayList<AlumnoModel>) alumnoRepository.findAll();
    }

    public AlumnoModel guardarUsuario(AlumnoModel alumno){
        return alumnoRepository.save(alumno);
    }

    public Optional<AlumnoModel> obtenerPorId(Long id){
        return alumnoRepository.findById(id);
    }

    public ArrayList<AlumnoModel> obtenerPorNombre(String nombre){
        return alumnoRepository.findByNombre(nombre);
    }

    public boolean eliminarAlumno(Long id){
        try{
            alumnoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}