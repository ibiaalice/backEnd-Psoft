package com.service;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.dao.DisciplineDAO;
import com.model.Discipline;

import net.minidev.json.parser.JSONParser;




@Service
public class DisciplineService {
	
	private final DisciplineDAO disciplineDAO;
	
	public DisciplineService(DisciplineDAO disciplineDAO) throws ParseException, IOException, Exception {
		this.disciplineDAO = disciplineDAO;
		//this.saveAllDisciplines();
		
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
	
	public void createAllDiscipline(Discipline discipline) {
		 disciplineDAO.save(discipline);
	}
	
/*public void saveAllDisciplines()  throws IOException, ParseException, Exception{
	JSONArray jsonArray;
	
	JSONParser jsonParser = new JSONParser();
	FileReader disciplines = new FileReader("src/main/java/com/util/disciplinas.json");
	
	jsonArray = (JSONArray) jsonParser.parse(disciplines);
	
	//aqui que a mágica acontece:
	((Collection) jsonArray).stream().forEach(discipline ->{
		JSONObject object = (JSONObject) discipline;
		
		
		String name = "";
		//a chance de isso tá errada é de mais de 3000 pontos de poder
		try {
			name = (String) object.get("nome");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		this.create(new Discipline(name));
		
		
	});
		
	}*/
	
}
