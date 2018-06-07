package com.focus.levelup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.focus.levelup.model.User;
import com.focus.levelup.services.LoginService;

import ch.qos.logback.core.net.LoginAuthenticator;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("aqui")
	public String loginPage() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal().equals("anonymousUser")) {
			
			System.out.println( auth.getPrincipal() );
			
			User user = (User)auth.getPrincipal();
			
			System.out.println("Username:"+ user.getIdUser() );
			return "/home";
		}
		
		return "backend/login/login";
	}

	@RequestMapping("index")
	public String login() {		
		return "backend/login/Login";
		
	}
	
	@RequestMapping("authentication")
	public ModelAndView authentication(Model model, @RequestParam String email,@RequestParam String password) {
		
		String pagina="";
		List<User> user = loginService.loginAuthentication(email, "$2a$10$hnC.Foxw7GWja0pNIR58vevLgXrI4N8viYt/PCFeHS8sWjTgRckMy" );
		
		if( !user.isEmpty() ) {
			
			pagina = "redirect:/Dashboard/index";
			for(User u : user) {
				model.addAttribute("name",u.getFirstName());
			}
		}else {
			pagina = "redirect:/login/index";
		}

		return new ModelAndView(pagina);
		
	}
	
	@RequestMapping("logout")
	public String logout() {
		
		return "backend/login/Login";
		
	}
	
	
}
