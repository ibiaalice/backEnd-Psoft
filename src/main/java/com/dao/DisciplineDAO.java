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

	Discipline save(Discipline discipline);

	Discipline findById(long id);

	@Query(value="Select * from discipline d where d.name = :nome", nativeQuery = true)
	Discipline[] findByName(@Param("nome") String name);


	@Query(value = "SELECT d FROM Discipline d WHERE d.name LIKE ('%',:substring,'%')")
	List<Discipline> findBySubstring(@Param("substring") String substring);

}
