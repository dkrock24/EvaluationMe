package com.focus.levelup.landing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus.levelup.model.Plane;
import com.focus.levelup.model.PlanesDetail;
import com.focus.levelup.services.PricingDetailService;
import com.focus.levelup.services.PricingService;

@Controller
@RequestMapping("landing")
public class landingController {
	
	@Autowired
	PricingService pricingService;
	
	@Autowired
	PricingDetailService pricingDetail;


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
		List<PlanesDetail> pricingDetails = (List<PlanesDetail>) pricingDetail.findAll();
		
		model.addAttribute("pricing", pricing);
		model.addAttribute("pricingDetail", pricingDetails);
		
		
		return "landing/pricing";
	}
	
	@RequestMapping("features")
	public String features() {
		
		return "landing/features";
	}
}
