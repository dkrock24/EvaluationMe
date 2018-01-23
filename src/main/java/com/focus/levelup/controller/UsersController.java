package com.focus.levelup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.focus.levelup.model.Roles;
import com.focus.levelup.model.Users;
import com.focus.levelup.services.RoleServices;
import com.focus.levelup.services.UserService;

@Controller
@RequestMapping("Users")
public class UsersController {

	@Autowired
	UserService usersServices;
	
	@Autowired
	RoleServices roleServices;
	
	@RequestMapping("index")
	public String users(Model model) {
		
		List<Users> user =  (List<Users>) usersServices.findAll();
		
		model.addAttribute("users", user);
		
		return "users/index";
	}
	
	@RequestMapping(value= "edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable int id) {
		
		Users user =  usersServices.findOne(id);
		
		List<Roles> role =  (List<Roles>) roleServices.findAll();
		
		model.addAttribute("users", user);
		model.addAttribute("roles", role);
		
		return "users/update";
	}
	
	@RequestMapping(value= "saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute("Users") Users users, BindingResult result ) {
		
		Users user =  usersServices.findOne(users.getIdUser());
		
		user.setRole(users.getRole());		
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setEmail(users.getEmail());
		user.setStatus(users.getStatus());
		
		usersServices.save( user );
		
		return new ModelAndView("redirect:/Users/index");
	}
	
	
}