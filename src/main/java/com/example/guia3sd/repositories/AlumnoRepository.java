package com.example.guia3sd.repositories;

import java.util.ArrayList;

import com.example.guia3sd.models.AlumnoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository <AlumnoModel, Long> {
    public abstract ArrayList<AlumnoModel> findByNombre(String nombre);
}