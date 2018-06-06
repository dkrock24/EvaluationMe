package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;

import com.focus.levelup.model.Country;

public interface CountryService extends CrudRepository<Country, Integer> {

}
