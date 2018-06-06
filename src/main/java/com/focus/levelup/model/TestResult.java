package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test_results database table.
 * 
 */
@Entity
@Table(name="test_results")
@NamedQuery(name="TestResult.findAll", query="SELECT t FROM TestResult t")
public class TestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_result")
	private int idResult;

	private int state;

	//bi-directional many-to-one association to Answer
	@ManyToOne
	@JoinColumn(name="id_answer")
	private Answer answer;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="id_question")
	private Question question;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="id_test")
	private Test test;

	public TestResult() {
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

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}