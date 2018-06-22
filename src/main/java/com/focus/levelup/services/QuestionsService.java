package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;
import com.focus.levelup.model.Question;

public interface QuestionsService extends CrudRepository<Question, Integer> {

//	@Query("SELECT q FROM Questions q ORDER BY q.idQuestions ASC")
//	List<Question> findAllOrderedByIdAsc();
//
//	@Query("SELECT q FROM Questions q ORDER BY q.idQuestions DESC")
//	List<Question> findAllOrderedByIdDesc();
//
//	@Query("SELECT q FROM Questions q WHERE q.status = :status")
//	List<Question> findAllByStatus(@Param("status") int status);
}
