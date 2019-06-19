package service;
import org.springframework.stereotype.Service;

import dao.DisciplineDAO;
import model.Discipline;

@Service
public class DisciplineService {
	
	private final DisciplineDAO disciplineDAO;
	
	public DisciplineService(DisciplineDAO disciplineDAO) {
		this.disciplineDAO = disciplineDAO;
	}
	
	public Discipline create(Discipline discipline) {
		return disciplineDAO.save(discipline);
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
	
	public boolean containsDiscipline(long id) {
		Discipline discipline = disciplineDAO.findById(id);
		return !(discipline == null);
	}
	
	
}
