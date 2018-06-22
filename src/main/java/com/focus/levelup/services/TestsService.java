package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;
import com.focus.levelup.model.Test;

public interface TestsService extends CrudRepository<Test, Integer> {

//	@Query("SELECT t FROM Tests t ORDER BY t.idTest ASC")
//	List<Test> findAllOrderedByIdAsc();
//
//	@Query("SELECT t FROM Tests t ORDER BY t.idTest DESC")
//	List<Test> findAllOrderedByIdDesc();
//
//	@Query("SELECT t FROM Tests t WHERE t.status = :status")
//	List<Test> findAllByStatus(@Param("status") int status);
}
