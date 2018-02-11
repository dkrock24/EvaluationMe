package com.focus.levelup.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("landing")
public class landingController {

	@RequestMapping("index")
	public String landing() {
		
		return "landing/index";
	}
	
	@RequestMapping("about")
	public String about() {
		
		return "landing/about";
	}
	
	@RequestMapping("contact-us")
	public String contactus() {
		
		return "landing/contact-us";
	}
	
	@RequestMapping("login")
	public String login() {
		
		return "landing/login";
	}
	
	@RequestMapping("pricing")
	public String pricing() {
		
		return "landing/pricing";
	}
}
