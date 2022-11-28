package com.developer.springboot.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.springboot.backend.apirest.models.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
