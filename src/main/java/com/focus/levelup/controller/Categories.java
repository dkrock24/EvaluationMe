package com.focus.levelup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus.levelup.model.Category;
import com.focus.levelup.services.CategoriesService;

@Controller
@RequestMapping("Categories")
public class Categories {
	
	@Autowired
	CategoriesService categoriesServices;

	@RequestMapping("index")
	public String categories(Model model) {
		
		List<Category> categories =  (List<Category>) categoriesServices.findAll();
		
		model.addAttribute("categories", categories);
		
		return "backend/categories/categories";
	}
}
