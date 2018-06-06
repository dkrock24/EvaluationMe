package com.focus.levelup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.focus.levelup.model.User;
import com.focus.levelup.services.LoginService;

@Controller
public class LoginController {
	
	//@Autowired
	//LoginService loginService;

	@RequestMapping("Login")
	public String login() {		
		return "backend/login/Login";
		
	}
	
	@RequestMapping("authentication")
	public String authentication(Model model, @RequestParam String email,@RequestParam String password) {
		
		//Users user = (Users) loginService.loginAuthentication( email, "$2a$10$5I3f3fLKvAEjEvYtCqU0NeHu5MyxkXB.To.2EmIOBjuANDzln4PF6" );
		//if( user != null ) {
			//System.out.println( user.getFirstName() );
		//}
		
		return "backend/login/Login";
		
	}
}
