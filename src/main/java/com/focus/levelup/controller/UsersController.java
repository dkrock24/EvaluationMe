package com.focus.levelup.controller;

import java.util.Date;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.focus.levelup.model.User;
import com.focus.levelup.services.RoleServices;
import com.focus.levelup.services.UserService;


@Controller
@RequestMapping("Users")
public class UsersController {

	@Autowired
	UserService usersService;
	
	@Autowired
	RoleServices roleServices;
	
	@Autowired
	BCryptPasswordEncoder encrypte;
	
	@RequestMapping("index")
	public String users(Model model) {
		
		List<User> user =  (List<User>) usersService.findAll();
		
		System.out.println(user);
		
		model.addAttribute("users", user);
		
		return "backend/users/index";
	}
	
	@RequestMapping("newUser")
	public String newUser(Model model) {
		
		Iterable<com.focus.levelup.model.Role> role = roleServices.findAll();
		model.addAttribute("roles", role);
			
		return "backend/users/newUser";
	}
	
	@RequestMapping(value= "saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("Users") User users, BindingResult result ) {
		
		Date d = new Date();


		User user =  new User();
		
		user.setRole(users.getRole());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setEmail(users.getEmail());
		user.setStatus(users.getStatus());
		user.setPassword(encrypte.encode(users.getPassword()));
		user.setAge(d);
		user.setCreated(d);
		
		usersService.save( user );
		
		return new ModelAndView("redirect:/Users/index");
	}
	
	@RequestMapping(value= "edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable int id) {
		
		User user =  usersService.findOne(id);
		
		Iterable<com.focus.levelup.model.Role> role = roleServices.findAll();
		
		model.addAttribute("users", user);
		model.addAttribute("roles", role);
		
		return "users/update";
	}
	
	@RequestMapping(value= "saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute("Users") User users, BindingResult result ) {
		
		User user =  usersService.findOne(users.getIdUser());
		

		user.setRole(users.getRole());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setEmail(users.getEmail());
		user.setStatus(users.getStatus());
		
		usersService.save( user );
		
		return new ModelAndView("redirect:/Users/index");
	}
	
	
}
