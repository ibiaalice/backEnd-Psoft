package com.service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.dao.UserDAO;
import com.model.Usuario;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DisciplineDAO;
import com.model.Discipline;

@Service
public class DisciplineService {

	private final DisciplineDAO disciplineDAO;

	@Autowired
	private final UserDAO userDAO;

	public DisciplineService(DisciplineDAO disciplineDAO, UserDAO userDAO)  {

		this.disciplineDAO = disciplineDAO;
		this.userDAO = userDAO;
		//this.deleteAll();
		/*try {
			this.saveAll();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}*/


	}

	public Discipline create(Discipline discipline) {
		return (Discipline) disciplineDAO.save(discipline);
	}

	public Discipline findById(long id) {
		return disciplineDAO.findById(id);
	}

	public void deleteAll(){
		disciplineDAO.deleteAll();
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


	/**
	 * Isso aqui pode dar muito ruim
	 * @throws JSONException
	 */
	public void saveAll() throws FileNotFoundException, ParseException, JSONException {


		List<String> list = new ArrayList<String>();
		JSONArray array = new JSONArray("[{\"nome\":\"ADMINISTRAÇÃO\"},{\"nome\":\"ADMINISTRAÇÃO DE SISTEMAS\"},{\"nome\":\"ADMINISTRAÇÃO DE SISTEMAS DE INFORMAÇÃO\"},{\"nome\":\"ALGEBRA LINEAR I\"},{\"nome\":\"ALGORITMOS AVANÇADOS I\"},{\"nome\":\"ALGORITMOS AVANCADOS II\"},{\"nome\":\"ALGORITMOS AVANCADOS III\"},{\"nome\":\"ANÁLISE DE SISTEMAS\"},{\"nome\":\"ANÁLISE E TÉCNICAS DE ALGORITMOS\"},{\"nome\":\"APLICAÇÕES DE GRAFOS\"},{\"nome\":\"APLICAÇÕES DE PLP\"},{\"nome\":\"AVALIAÇÃO DE DESEMPENHO DE SISTEMAS DISCRETOS\"},{\"nome\":\"BANCO DE DADOS 1\"},{\"nome\":\"BANCO DE DADOS 2\"},{\"nome\":\"BASQUETEBOL FEM\"},{\"nome\":\"BASQUETEBOL MAS\"},{\"nome\":\"CALCULO DIFERENCIAL E INTEGRAL I\"},{\"nome\":\"CALCULO DIFERENCIAL E INTEGRAL II\"},{\"nome\":\"CÁLCULO NUMÉRICO\"},{\"nome\":\"CIÊNCIA DE DADOS DESCRITIVA\"},{\"nome\":\"CIÊNCIA DE DADOS PREDITIVA\"},{\"nome\":\"COMPILADORES\"},{\"nome\":\"DESENVOLVIMENTO DE APLICAÇÕES CORPORATIVAS AVANÇADAS\"},{\"nome\":\"DIREITO E CIDADANIA\"},{\"nome\":\"ECONOMIA\"},{\"nome\":\"ECONOMIA DE TECNOLOGIA DA INFORMAÇÃO\"},{\"nome\":\"EMPREENDEDORISMO\"},{\"nome\":\"EMPREENDEDORISMO EM SOFTWARE\"},{\"nome\":\"ENGENHARIA DE SOFTWARE\"},{\"nome\":\"ESTÁGIO INTEGRADO\"},{\"nome\":\"ESTÁGIO INTEGRADO I\"},{\"nome\":\"ESTAGIO INTEGRADO II\"},{\"nome\":\"ESTAGIO INTEGRADO III\"},{\"nome\":\"ESTATÍSTICA APLICADA\"},{\"nome\":\"ESTRUTURA DE DADOS\"},{\"nome\":\"FUNDAMENTOS DE MATEMATICA PARA CIÊNCIA DA COMPUTACAO I\"},{\"nome\":\"FUNDAMENTOS DE MATEMATICA PARA CIÊNCIA DA COMPUTACAO II\"},{\"nome\":\"FUNDAMENTOS DE PROGRAMAÇÃO CONCORRENTE\"},{\"nome\":\"FUTSAL\"},{\"nome\":\"GERÊNCIA DE REDES DE COMPUTADORES\"},{\"nome\":\"GESTÃO DE PROJETOS\"},{\"nome\":\"GESTÃO DE SISTEMAS DE INFORMAÇÃO\"},{\"nome\":\"GOVERNÂNCIA DA INTERNET\"},{\"nome\":\"INFORMÁTICA E SOCIEDADE\"},{\"nome\":\"INGLÊS\"},{\"nome\":\"INTELIGÊNCIA ARTIFICIAL\"},{\"nome\":\"INTERCONEXÃO DE REDES DE COMPUTADORES\"},{\"nome\":\"INTRODUÇÃO A BANCO DE DADOS E MINERAÇÃO DE DADOS\"},{\"nome\":\"INTRODUÇÃO À CIÊNCIA DA COMPUTAÇÃO\"},{\"nome\":\"INTRODUÇÃO À COMPUTAÇÃO\"},{\"nome\":\"INTRODUÇÃO À PROBABILIDADE\"},{\"nome\":\"JOGOS DIGITAIS\"},{\"nome\":\"LABORATÓRIO DE ENGENHARIA DE SOFTWARE\"},{\"nome\":\"LABORATÓRIO DE ESTRUTURA DE DADOS\"},{\"nome\":\"LABORATÓRIO DE INTERCONEXÃO DE REDES DE COMPUTADORES\"},{\"nome\":\"LABORATÓRIO DE ORGANIZAÇÃO E ARQUITETURA DE COMPUTADORES\"},{\"nome\":\"LABORATÓRIO DE PROGRAMAÇÃO 1\"},{\"nome\":\"LABORATÓRIO DE PROGRAMAÇÃO 2\"},{\"nome\":\"LEITURA E PRODUÇÃO DE TEXTO\"},{\"nome\":\"LÍNGUA PORTUGUESA\"},{\"nome\":\"LÓGICA PARA COMPUTAÇÃO\"},{\"nome\":\"METODOLOGIA CIENTÍFICA\"},{\"nome\":\"MÉTODOS E SOFTWARE NUMÉRICOS\"},{\"nome\":\"MÉTODOS ESTATÍSTICOS\"},{\"nome\":\"ORGANIZAÇÃO E ARQUITETURA DE COMPUTADORES\"},{\"nome\":\"PARADIGMAS DE LINGUAGENS DE PROGRAMAÇÃO\"},{\"nome\":\"PERCEPÇÃO COMPUTACIONAL\"},{\"nome\":\"PRÁTICA DE ENSINO DE COMPUTAÇÃO I\"},{\"nome\":\"PRÁTICA DE ENSINO DE COMPUTAÇÃO II\"},{\"nome\":\"PRINCÍPIOS DE DESENVOLVIMENTO WEB\"},{\"nome\":\"PROGRAMAÇÃO 1\"},{\"nome\":\"PROGRAMAÇÃO 2\"},{\"nome\":\"PROGRAMAÇÃO CONCORRENTE\"},{\"nome\":\"PROGRAMAÇÃO FUNCIONAL\"},{\"nome\":\"PROJETO DE REDES DE COMPUTADORES\"},{\"nome\":\"PROJETO DE SISTEMAS OPERACIONAIS\"},{\"nome\":\"PROJETO DE SOFTWARE\"},{\"nome\":\"PROJETO DE TRABALHO DE CONCLUSAO DE CURSO\"},{\"nome\":\"PROJETO EM COMPUTAÇÃO 1\"},{\"nome\":\"PROJETO EM COMPUTAÇÃO 2\"},{\"nome\":\"RECUPERAÇÃO DA INFORMAÇÃO E BUSCA NA WEB\"},{\"nome\":\"REDES DE COMPUTADORES\"},{\"nome\":\"SEMINÁRIOS\"},{\"nome\":\"SEMINÁRIOS (EDUCAÇÃO AMBIENTAL)\"},{\"nome\":\"SISTEMAS DE APOIO À DECISÃO\"},{\"nome\":\"SISTEMAS DE INFORMAÇÃO II\"},{\"nome\":\"SISTEMAS DE RECUPUPERAÇÃO DA INFORMAÇÃO\"},{\"nome\":\"SISTEMAS OPERACIONAIS\"},{\"nome\":\"SOCIOLOGIA INDUSTRIAL I\"},{\"nome\":\"TÉCNICAS DE PROGRAMAÇÃO\"},{\"nome\":\"TEORIA DA COMPUTAÇÃO\"},{\"nome\":\"TEORIA DOS GRAFOS\"},{\"nome\":\"TRABALHO DE CONCLUSAO DE CURSO\"},{\"nome\":\"VERIFICACAO E VALIDAÇÃO DE SOFTWARE\"},{\"nome\":\"VISÃO COMPUTACIONAL\"},{\"nome\":\"VISUALIZAÇÃO DE DADOS\"}]");
		for(int i = 0 ; i < array.length() ; i++){
			list.add((String) array.getJSONObject(i).get("nome"));
		}

		for(int i = 0; i < list.size(); i++)
			this.create(new Discipline(list.get(i)));
	}


	//Like e unlike






}