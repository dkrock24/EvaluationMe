package com.focus.levelup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.focus.levelup.model.Company;
import com.focus.levelup.model.CompanyUser;
import com.focus.levelup.model.Country;
import com.focus.levelup.model.User;
import com.focus.levelup.services.CompanyService;
import com.focus.levelup.services.CompanyUserService;
import com.focus.levelup.services.CountryService;


@Controller
@RequestMapping("Company")
public class CompanyController {
	
	@Autowired
	CompanyService companyServices;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CompanyUserService companyUserService;

	@RequestMapping("index")
	public String index(Model model) {
		
		Company company = (Company) companyServices.findOne(5 );				
		model.addAttribute("company", company);		
		
		return "backend/company/index";
	}
	
	@RequestMapping("saveCompany")
	public ModelAndView saveCompany( @ModelAttribute("Company") Company comp, BindingResult result ) {
		
		Company company = new Company();
		Country country =  countryService.findOne( comp.getCountry() );
		
		company.setName( comp.getName() );
		company.setTel( comp.getTel() );
		company.setDescription( comp.getDescription() );
		company.setEmail( comp.getEmail() );
		company.setState( comp.getState() );
		company.setCountry( country.getIdCountry() );
		company.setStatus( 1 );		
		
		company = companyServices.save(company);
		
		CompanyUser cu = new CompanyUser();
		cu.setCompany( company.getIdCompany() );
		cu.setUser( 2 );
		
		companyUserService.save(cu);
		
		
		
		return new ModelAndView("redirect:/Company/index");
	}
}
