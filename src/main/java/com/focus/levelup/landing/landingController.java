package com.focus.levelup.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("landing")
public class landingController {
	


	@GetMapping("index")
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
	public String pricing(Model model) {
		
		List<Plane> pricing = (List<Plane>) pricingService.findAll();
		
		model.addAttribute("pricing", pricing);
		
		return "landing/pricing";
	}
	
	@RequestMapping("features")
	public String features() {
		
		return "landing/features";
	}
}
