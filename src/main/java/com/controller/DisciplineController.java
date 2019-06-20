package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exception.DisciplineNotExistsException;
import exception.DisciplineNotFoundException;
import com.model.*;
import com.service.DisciplineService;

@RestController
@RequestMapping({ "/v1/disciplines" })
public class DisciplineController {
	private DisciplineService disciplineService;

	public DisciplineController(DisciplineService disciplineService) {
		this.disciplineService = disciplineService;
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Discipline> findById(@PathVariable long id) {
		Discipline discipline = disciplineService.findById(id);

		if (!disciplineService.containsDiscipline(id)) {
			throw new DisciplineNotFoundException("Discipline not found!");
		}

		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{name}")
	@ResponseBody
	public ResponseEntity<String> findByName(@PathVariable String name) {
		String disciplines = disciplineService.findByName(name);

		if (!disciplineService.containsDiscipline(name)) {
			throw new DisciplineNotFoundException("Discipline not found!");
		}

		return new ResponseEntity<String>(disciplines, HttpStatus.OK);
	}

	@PostMapping(value = "/signup")
	@ResponseBody
	public ResponseEntity<Discipline> create(@RequestBody Discipline discipline) {
		if(disciplineService.containsDiscipline(discipline.getId())) {
			throw new DisciplineNotExistsException("Discipline alreayd exists!");
		}
		
		return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
	}
	
	

}