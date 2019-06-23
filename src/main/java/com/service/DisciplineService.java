package com.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.DisciplineDAO;
import com.model.Discipline;

@Service
public class DisciplineService {
	
	private final DisciplineDAO disciplineDAO;
	
	public DisciplineService(DisciplineDAO disciplineDAO) {
		this.disciplineDAO = disciplineDAO;
	}
	
	public Discipline create(Discipline discipline) {
		return (Discipline) disciplineDAO.save(discipline);
	}
	
	public Discipline findById(long id) {
		return disciplineDAO.findById(id);
	}
	
	
	
	public String findByName(String name) {
		Discipline[] disciplines = disciplineDAO.findByName(name);
		return concateString(disciplines);
		
	}
	
	private String concateString(Discipline[] disciplines) {
		String listDiscipline = "";
		for(int i = 0; i < disciplines.length; i ++) {
			listDiscipline = disciplines[i].toString();
		}
		
		return listDiscipline;
	}
	
	public boolean containsDiscipline(String name) {
		Discipline[] disciplines = disciplineDAO.findByName(name);
		return disciplines.length > 0;
	}
	
	
	public List findBySubstring(String substring) {
		List<Discipline> disciplines = disciplineDAO.findBySubstring(substring);
		
		return disciplines;
	}
	
	private String concateStringByList(List disciplines) {
		String listDiscipline = "";
		for(int i = 0; i < disciplines.size(); i ++) {
			listDiscipline = disciplines.get(i).toString();
		}
		
		return listDiscipline;
	}
	
	public boolean containsDiscipline(long id) {
		Discipline discipline = disciplineDAO.findById(id);
		return !(discipline == null ||  discipline.getName() == "");
	}
	
	public List<Discipline> findAll(){
		return this.disciplineDAO.findAll();
	}
	
}

