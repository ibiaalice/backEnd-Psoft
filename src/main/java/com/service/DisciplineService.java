package com.service;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.dao.DisciplineDAO;
import com.model.Discipline;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

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
	
	public String findBySubstring(String substring) {
		List<Discipline> disciplines = disciplineDAO.findBySubstring(substring);
		String listDisciplines = concateString(disciplines);
		return listDisciplines;
	}
	
	
	private String concateString(List disciplines) {
		String listDiscipline = "";
		for(int i = 0; i < disciplines.size(); i ++) {
			listDiscipline = disciplines.get(i).toString();
		}
		
		return listDiscipline;
	}
	
	public boolean containsDiscipline(String name) {
		Discipline[] disciplines = disciplineDAO.findByName(name);
		return disciplines.length > 0;
	}
	
	public boolean containsDiscipline(long id) {
		Discipline discipline = disciplineDAO.findById(id);
		return !(discipline == null ||  discipline.getName() == "");
	}
	
	public void saveAllDisciplines()  throws IOException, net.minidev.json.parser.ParseException{
		
		JSONArray jsonArray;
		
		JSONParser jsonParser = new JSONParser();
		FileReader disciplines = new FileReader("src/main/java/com/util");
		
		jsonArray = (JSONArray) jsonParser.parse(disciplines);
		
		//aqui que a mágica acontece:
		jsonArray.stream().forEach(discipline ->{
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
		
	}
	
}
