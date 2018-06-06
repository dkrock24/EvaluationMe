package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;

import com.focus.levelup.model.TestResult;

public interface TestResultsService extends CrudRepository<TestResult, Integer> {

}
