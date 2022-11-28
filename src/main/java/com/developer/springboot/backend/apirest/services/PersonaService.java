package com.developer.springboot.backend.apirest.services;

import java.util.List;

import com.developer.springboot.backend.apirest.models.entity.Persona;

public interface PersonaService {
	
	public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);
	
	

}
