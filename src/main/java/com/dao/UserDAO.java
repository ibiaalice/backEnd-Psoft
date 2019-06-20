package com.dao;
import com.model.*;
import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<T, ID extends Serializable> extends JpaRepository<User, String> {
	User save(User user);
	
	/**
	 * Método de busca com a característica do email.
	 * @param email email do user
	 * @return user com mesmo email.
	 */
	@Query(value = "Select * from user u where u.email = :plogin", nativeQuery= true) 
	User findByEmail(@Param("plogin") String email);


}
