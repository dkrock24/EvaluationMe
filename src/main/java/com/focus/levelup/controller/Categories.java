package com.focus.levelup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Categories")
public class Categories {

	@RequestMapping("index")
	public String categories() {
		return "backend/categories/categories";
	}
}
