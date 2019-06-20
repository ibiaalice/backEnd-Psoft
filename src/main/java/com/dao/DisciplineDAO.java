package com.dao;

import java.io.Serializable;
import java.lang.reflect.Array;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
	Discipline[] findByName(String name);

}
