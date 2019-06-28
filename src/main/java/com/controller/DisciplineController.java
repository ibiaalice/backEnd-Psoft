package com.controller;

import java.util.List;

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

	@GetMapping(value = "/nome/{name}")
	@ResponseBody
	public ResponseEntity<Discipline> findByName(@PathVariable String name) {
		Discipline discipline = disciplineService.findByName(name);

		if (!disciplineService.containsDiscipline(name)) {
			throw new DisciplineNotFoundException("Discipline not found!");
		}

		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}

	@GetMapping(value = "/substring/{substring}")
	@ResponseBody
	public ResponseEntity<List> findBySubstring(@PathVariable String substring) {
		List disciplines = disciplineService.findBySubstring(substring);

		return new ResponseEntity<List>(disciplines, HttpStatus.OK);

	}

	@GetMapping(value = "find")
	@ResponseBody
	public ResponseEntity<List> findAll(){
		List listDisciplines = disciplineService.findAll();
		return new ResponseEntity<List>(listDisciplines, HttpStatus.OK);

	}

	@PostMapping(value = "/signup")
	@ResponseBody
	public ResponseEntity<Discipline> create(@RequestBody Discipline discipline) {
		if (disciplineService.containsDiscipline(discipline.getId())) {
			throw new DisciplineNotExistsException("Discipline alreayd exists!");
		}
		disciplineService.create(discipline);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
	}



	//parte do like :

	@PostMapping(value = "likes/liked") //tomando erro 405
	public ResponseEntity<Discipline>like(@RequestBody Like like) {
		long id = like.getIdUser();
		String email = like.getEmail();

		Discipline discipline = this.disciplineService.findById(id);
		if(!disciplineService.containsDiscipline(id))
		this.disciplineService.liked(id, email);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
	}

	@PostMapping(value = "likes/unliked")
	public void Unlike(@RequestBody long id , @RequestBody String email)  {

		this.disciplineService.unliked(id, email);
	}






}
