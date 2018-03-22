package com.focus.levelup.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.focus.levelup.model.Users;

public interface LoginService extends CrudRepository<Users, Integer>{
	
	public Users loginAuthentication(@Param("email") String email, @Param("passwd") String passwd);
}
