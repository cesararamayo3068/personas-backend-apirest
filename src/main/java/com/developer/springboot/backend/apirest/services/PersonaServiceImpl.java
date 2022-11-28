package com.developer.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.springboot.backend.apirest.models.entity.Persona;
import com.developer.springboot.backend.apirest.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable pageable) {
		
		return personaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaRepository.deleteById(id);

	}

}
