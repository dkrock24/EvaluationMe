package com.focus.levelup.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.focus.levelup.model.QuestionType;

public interface QuestionTypesService extends CrudRepository<QuestionType, Integer> {

//	@Query("SELECT q FROM QuestionTypes q ORDER BY q.idType ASC")
//	List<QuestionType> findAllOrderedByIdAsc();
////
//	@Query("SELECT q FROM QuestionTypes q ORDER BY q.idType DESC")
//	List<QuestionType> findAllOrderedByIdDesc();
//
//	@Query("SELECT q FROM QuestionTypes q WHERE q.status = :status")
//	List<QuestionType> findAllByStatus(@Param("status") int status);
}
