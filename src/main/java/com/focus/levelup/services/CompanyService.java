package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;

import com.focus.levelup.model.Company;

public interface CompanyService extends CrudRepository<Company, Integer>{

}
