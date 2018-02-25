package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test_results database table.
 * 
 */
@Entity
@Table(name="test_results")
@NamedQuery(name="TestResults.findAll", query="SELECT t FROM TestResults t")
public class TestResults implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_result")
	private int idResult;

	private int state;

	//bi-directional many-to-one association to Answers
	@ManyToOne
	@JoinColumn(name="id_answer")
	private Answers answers;

	//bi-directional many-to-one association to Questions
	@ManyToOne
	@JoinColumn(name="id_question")
	private Questions questions;

	//bi-directional many-to-one association to Tests
	@ManyToOne
	@JoinColumn(name="id_test")
	private Tests tests;

	public TestResults() {
	}

	public int getIdResult() {
		return this.idResult;
	}

	public void setIdResult(int idResult) {
		this.idResult = idResult;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Answers getAnswer() {
		return this.answers;
	}

	public void setAnswer(Answers answers) {
		this.answers = answers;
	}

	public Questions getQuestion() {
		return this.questions;
	}

	public void setQuestion(Questions questions) {
		this.questions = questions;
	}

	public Tests getTest() {
		return this.tests;
	}

	public void setTest(Tests tests) {
		this.tests = tests;
	}

}