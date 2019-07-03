package com.controller;

import java.io.FileNotFoundException;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.json.ParseException;
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

@Api(value="API Rest Discipline")
@RestController
@RequestMapping({ "/v1/disciplines" })
public class DisciplineController {
	private DisciplineService disciplineService;

	public DisciplineController(DisciplineService disciplineService) {
		this.disciplineService = disciplineService;
	}

	//Métodos de Busca


	@ApiOperation(value="Método de rota para a busca por ID")
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Discipline> findById(@PathVariable long id) {
		Discipline discipline = disciplineService.findById(id);
		if (!disciplineService.containsDiscipline(id)) {
			throw new DisciplineNotFoundException("Discipline not found!");
		}

		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}

	@ApiOperation(value="Método de rota para a busca pelo nome da Disciplina")
	@GetMapping(value = "/nome/{name}")
	@ResponseBody
	public ResponseEntity<Discipline> findByName(@PathVariable String name) {
		Discipline discipline = disciplineService.findByName(name);

		if (!disciplineService.containsDiscipline(name)) {
			throw new DisciplineNotFoundException("Discipline not found!");
		}

		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}

	@ApiOperation(value="Método de rota para a busca pelo nome incompleto da Disciplina")
	@GetMapping(value = "/substring/{substring}")
	@ResponseBody
	public ResponseEntity<List> findBySubstring(@PathVariable String substring) {
		List disciplines = disciplineService.findBySubstring(substring);

		return new ResponseEntity<List>(disciplines, HttpStatus.OK);

	}

	@ApiOperation(value="Método de rota para a listagem de todos os objetos Discipline criadas")
	@GetMapping(value="find")
	@ResponseBody
	public ResponseEntity<List> findAll(){
		List listDisciplines = disciplineService.findAll();
		return new ResponseEntity<List>(listDisciplines, HttpStatus.OK);

	}

	//métodos de criação

	@ApiOperation(value="Método de criação do objeto Discipline")
	@PostMapping(value="/signup")
	@ResponseBody
	public ResponseEntity<Discipline> create(@RequestBody Discipline discipline) {
		if (disciplineService.containsDiscipline(discipline.getId())) {
			throw new DisciplineNotExistsException("Discipline alreayd exists!");
		}
		disciplineService.create(discipline);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
	}



	//parte do like :

	@ApiOperation(value="Método de adição do like no objeto Discipline")
	@PostMapping(value="likes/liked") //tomando erro 405
	@ResponseBody
	public ResponseEntity<Discipline>like(@RequestBody Like like) {
		long id = like.getIdUser();
		String email = like.getEmail();

		Discipline discipline = this.disciplineService.findById(id);
		discipline.liked(email);
		disciplineService.create(discipline);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}

	@ApiOperation("Método de remoção de like no objeto Discipline")
	@PostMapping(value="likes/unliked")
	@ResponseBody
	public ResponseEntity<Discipline> Unlike(@RequestBody Like like)  {
		long id = like.getIdUser();
		String email = like.getEmail();

		Discipline discipline = disciplineService.findById(id);
		this.disciplineService.unliked(id, email);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);

	}

	@ApiOperation(value="Método de verificação se o usuário curtiu ou não a disciplina")
	@PostMapping(value = "likes/{email}")
	@ResponseBody
	public ResponseEntity<Boolean> containsLike(@RequestBody Like like){
		long id = like.getIdUser();
		String email = like.getEmail();
		Discipline disc = disciplineService.findById(id);
		boolean containsLike = disc.containsLike(email);

		return new ResponseEntity<Boolean>(containsLike, HttpStatus.OK);

	}



}
