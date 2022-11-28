package com.developer.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.developer.springboot.backend.apirest.models.entity.Persona;
import com.developer.springboot.backend.apirest.services.PersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/personas")
	public List<Persona> index() {
		return personaService.findAll();

	}
	

	@GetMapping("/personas/page/{page}")
	public Page<Persona> index(@PathVariable Integer page) {
		return personaService.findAll(PageRequest.of(page, 4));

	}

	@GetMapping("/personas/{id}")
	public Persona show(@PathVariable Long id) {
		return personaService.findById(id);
	}

	@PostMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona) {
		return personaService.save(persona);
	}

	@PutMapping("/personas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
		Persona personaActual = personaService.findById(id);
		personaActual.setPerApellido(persona.getPerApellido());
		personaActual.setPerNombre(persona.getPerNombre());
		personaActual.setPerFechaNacimiento(persona.getPerFechaNacimiento());
		personaActual.setPerNumeroDocumento(persona.getPerNumeroDocumento());
		personaActual.setPerTipoDocumento(persona.getPerTipoDocumento());

		return personaService.save(personaActual);

	}
	
	@DeleteMapping ("/personas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personaService.delete(id);
	}

}
