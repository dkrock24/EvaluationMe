package com.focus.levelup.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.focus.levelup.model.User;

public interface LoginService extends CrudRepository<User, Integer>{
	
	//public User loginAuthentication(@Param("email") String email, @Param("passwd") String passwd);
	
	@Query("SELECT u FROM User u WHERE u.email = :email and u.password = :passwd")
	List<User> loginAuthentication(@Param("email") String email, @Param("passwd") String passwd);
	
	//@Query("SELECT u FROM User u")
	//List<User> DemoUser();
}
