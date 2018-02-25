package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="answers")
@NamedQuery(name="Answers.findAll", query="SELECT a FROM Answers a")
public class Answers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_answer")
	private int idAnswer;

	@Lob
	private String answer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private int score;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Questions
	@ManyToOne
	@JoinColumn(name="id_question")
	private Questions questions;

	//bi-directional many-to-one association to TestResults
	@OneToMany(mappedBy="answers")
	private List<TestResults> testResults;

	public Answers() {
	}

	public int getIdAnswer() {
		return this.idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Questions getQuestion() {
		return this.questions;
	}

	public void setQuestion(Questions questions) {
		this.questions = questions;
	}

	public List<TestResults> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResults> testResults) {
		this.testResults = testResults;
	}

	public TestResults addTestResult(TestResults testResults) {
		getTestResults().add(testResults);
		testResults.setAnswer(this);

		return testResults;
	}

	public TestResults removeTestResult(TestResults testResults) {
		getTestResults().remove(testResults);
		testResults.setAnswer(null);

		return testResults;
	}

}