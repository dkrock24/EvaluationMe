package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;

import com.focus.levelup.model.Category;

public interface CategoriesService extends CrudRepository<Category, Integer>  {

}
