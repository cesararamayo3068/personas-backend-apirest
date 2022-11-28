package com.developer.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.developer.springboot.backend.apirest.models.entity.Persona;

public interface PersonaService {
	
	public List<Persona> findAll();
	
	public Page<Persona> findAll(Pageable pageable);
	
	public Persona findById(Long id);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);
	
	

}
