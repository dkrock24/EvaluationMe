package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;
import com.focus.levelup.model.QuizLevel;

public interface QuizLevelsService extends CrudRepository<QuizLevel, Integer> {

	//@Query("SELECT q FROM QuizLevels q ORDER BY q.idLevel ASC")
	//List<QuizLevel> findAllOrderedByIdAsc();

	//@Query("SELECT q FROM QuizLevels q ORDER BY q.idLevel DESC")
	//List<QuizLevel> findAllOrderedByIdDesc();

	//@Query("SELECT q FROM QuizLevels q WHERE q.status = :status")
	//List<QuizLevel> findAllByStatus(@Param("status") int status);
}
