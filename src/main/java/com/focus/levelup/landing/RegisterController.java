package com.focus.levelup.landing;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus.levelup.model.Company;
import com.focus.levelup.model.Country;
import com.focus.levelup.services.CompanyService;
import com.focus.levelup.services.CountryService;


@Controller
@RequestMapping("landing")
public class RegisterController {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CompanyService companyService;

	@RequestMapping("register")
	public String register(Model model) {
		
		ArrayList<Country> c = (ArrayList<Country>) countryService.findAll();
		
		model.addAttribute("country", c);		
		return "landing/registro";
	}
	
	@RequestMapping("insert")
	public String company(@ModelAttribute("Company") Company comp, BindingResult result) {
		
		if(comp == null) {
			return "landing/index";
		}
		
		Company company = new Company();
		
		company.setName(comp.getName());
		company.setDescription(comp.getDescription());
		company.setEmail(comp.getEmail());
		company.setTel(comp.getTel());
		company.setState(comp.getState());
		company.setCountry(comp.getCountry());
		company.setStatus(comp.getStatus());
		
		companyService.save(company);		
		
		return "landing/index";
	}
}
