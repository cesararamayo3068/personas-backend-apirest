package com.developer.springboot.backend.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.developer.springboot.backend.apirest.models.entity.Persona;

public interface PersonaRepository extends CrudRepository <Persona,Long>{

}
