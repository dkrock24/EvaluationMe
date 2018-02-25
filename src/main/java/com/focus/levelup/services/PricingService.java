package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;

import com.focus.levelup.model.Plane;

public interface PricingService extends CrudRepository<Plane, Integer>{

}
