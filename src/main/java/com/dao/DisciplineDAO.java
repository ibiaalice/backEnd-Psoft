package com.dao;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Discipline;
/**
 * Interface de comunicação com banco de dados
 * @author Beatriz Alice
 *
 * @param <T>
 * @param <ID>
 */
@Repository
public interface DisciplineDAO<T, ID extends Serializable> extends JpaRepository<Discipline, Long> {

	/**
	 * Método para salvar o objeto Discipline no banco de dados
	 * @param discipline Discipline para ser salva no banco de dados
	 * @return retorna uma cópia da classe salva
	 */
	Discipline save(Discipline discipline);

	/**
	 * Método para procura pela classe Discipline por ID
	 * @param id id a ser procurado
	 * @return retorna a classe com o id referente
	 */
	Discipline findById(long id);

	/**
	 * Método de pesquisa por nome da classe a Discipline
	 * @param name nome a ser procurado
	 * @return retorna uma classe Discipline
	 */
	@Query(value="Select * from discipline d where d.name = :nome", nativeQuery = true)
	Discipline findByName(@Param("nome") String name);

	/**
	 * Método de pesquisa por substring da classe Discipline
	 * @param substring substring a ser procurada
	 * @return retorna uma lista de Discipline que possuem a substring no nome
	 */
	@Query(value = "SELECT d FROM Discipline d WHERE d.name LIKE '%substring%' ")
	List<Discipline> findBySubstring(@Param("substring") String substring);


}
