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


import com.focus.levelup.model.QuizLevels;
import com.focus.levelup.model.Users;

import com.focus.levelup.services.QuizLevelsService;
import com.focus.levelup.services.QuizzesServices;
import com.focus.levelup.services.TestsService;



@Controller
@RequestMapping("Level")
public class LevelController {
	

	
	@Autowired
	QuizLevelsService QlevelServices;
	
	@Autowired
	QuizzesServices quizzesServices;
	
	@Autowired
	TestsService testServices;
	
	//@Autowired
	//QuizzController quizzcontroller;

	@RequestMapping("index")
	public String index(Model model) {
						
//		model.addAttribute("totalLanguages", quizzcontroller.totalProgramming());
//		model.addAttribute("totalLevels", quizzcontroller.totalLevels());
//		model.addAttribute("countQuizz", quizzcontroller.totalQuizz());
//		model.addAttribute("countPendingTest", quizzcontroller.totalPendingTest());
		
		return "quizzLevel/indexLevel";
	}
	
	@RequestMapping("addLevel")
	public String addLanguages(Model model) {
		
		List<QuizLevels> ql = (List<QuizLevels>) QlevelServices.findAll();
		
		model.addAttribute("ql",ql);
		
//		model.addAttribute("totalLanguages", quizzcontroller.totalProgramming());
//		model.addAttribute("totalLevels", quizzcontroller.totalLevels());
//		model.addAttribute("countQuizz", quizzcontroller.totalQuizz());
//		model.addAttribute("countPendingTest", quizzcontroller.totalPendingTest());
		
		return "quizzLevel/addLevel";
	}
	
	/*
	 * SAVE NEW PROGRAMMING LANGUAGES
	 */
	@RequestMapping("saveLevel")
	public ModelAndView saveLevel(@ModelAttribute("QuizLevels") QuizLevels level, BindingResult result) {
		
		QuizLevels ql = new QuizLevels();
		ql.setLevel(level.getLevel());
		ql.setStatus(level.getStatus());
		
		QlevelServices.save(ql);
		
		return new ModelAndView("redirect:/Level/addLevel");
	}	
	
	/*
	 * EDIT PROGRAMMING LANGUAGES
	 */
	@RequestMapping(value ="editLevel/{id}", method= RequestMethod.GET)
	public String editLevel(Model model,@PathVariable int id) {
		
		List<QuizLevels> ql = (List<QuizLevels>) QlevelServices.findAll();			
		QuizLevels ql_edit = QlevelServices.findOne(id);
		
		model.addAttribute("ql",ql);
		model.addAttribute("level", ql_edit);
		
		return ("quizzLevel/editLevel");
	}
	
	
	/*
	 * UPDATE PROGRAMMING LANGUAGES
	 */
	@RequestMapping("updateLevel")
	public ModelAndView updateLevel(@ModelAttribute("QuizLevels") QuizLevels level, BindingResult result) {
		
		QuizLevels ql = QlevelServices.findOne(level.getIdLevel());
		ql.setLevel(level.getLevel());
		ql.setStatus(level.getStatus());
		
		QlevelServices.save(ql);		
		
		return new ModelAndView("redirect:/Level/addLevel");
	}	
	
}
