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

import com.focus.levelup.model.Role;
//import com.focus.levelup.model.Statuses;
import com.focus.levelup.services.RoleServices;

@Controller
@RequestMapping("Roles")
public class RolesController {
	
	@Autowired
	RoleServices roleServices;

	@RequestMapping("index")
	public String roles(Model model) {
		
		List<Role> role =  (List<Role>) roleServices.findAll();
		
		model.addAttribute("data", role);
		
		return "backend/roles/index";
	}
	
	@RequestMapping(value= "edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable int id) {
		
		Role role =  roleServices.findOne(id);		
		model.addAttribute("data", role);
		
		return "roles/update";
	}
	
	@RequestMapping(value= "newRole")
	public String newRole(Model model) {
				
		return "roles/new";
	}
	
	@RequestMapping(value= "saveRole", method = RequestMethod.POST)
	public ModelAndView saveRole(Model model, @ModelAttribute("Roles") Role role, BindingResult result) {
		
		Role roles =  new Role();	
		
		roles.setRole(role.getRole());
		roles.setStatus(1);;
		
		roleServices.save(roles);
		
		return new ModelAndView("redirect:/Roles/index");
	}
	
	@RequestMapping(value= "saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(Model model, @ModelAttribute("Roles") Role role, BindingResult result) {
		
		Role roles =  roleServices.findOne(role.getIdRole());
		roles.setRole(role.getRole());
		roleServices.save(roles);
		
		return new ModelAndView("redirect:/Roles/index");
	}
	
	
	
	
}
