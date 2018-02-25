package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Questions.findAll", query="SELECT q FROM Questions q")
public class Questions implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_questions")
	private int idQuestions;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String question;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Answers
	@OneToMany(mappedBy="questions")
	private List<Answers> answers;

	//bi-directional many-to-one association to QuestionTypes
	@ManyToOne
	@JoinColumn(name="id_type")
	private QuestionTypes questionTypes;

	//bi-directional many-to-one association to Quizze
	@ManyToOne
	@JoinColumn(name="id_quiz")
	private Quizzes quizze;

	//bi-directional many-to-one association to TestResults
	@OneToMany(mappedBy="questions")
	private List<TestResults> testResults;

	public Questions() {
	}

	public int getIdQuestions() {
		return this.idQuestions;
	}

	public void setIdQuestions(int idQuestions) {
		this.idQuestions = idQuestions;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public List<Answers> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public Answers addAnswer(Answers answers) {
		getAnswers().add(answers);
		answers.setQuestion(this);

		return answers;
	}

	public Answers removeAnswer(Answers answers) {
		getAnswers().remove(answers);
		answers.setQuestion(null);

		return answers;
	}

	public QuestionTypes getQuestionType() {
		return this.questionTypes;
	}

	public void setQuestionType(QuestionTypes questionTypes) {
		this.questionTypes = questionTypes;
	}

	public Quizzes getQuizze() {
		return this.quizze;
	}

	public void setQuizze(Quizzes quizze) {
		this.quizze = quizze;
	}

	public List<TestResults> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResults> testResults) {
		this.testResults = testResults;
	}

	public TestResults addTestResult(TestResults testResults) {
		getTestResults().add(testResults);
		testResults.setQuestion(this);

		return testResults;
	}

	public TestResults removeTestResult(TestResults testResults) {
		getTestResults().remove(testResults);
		testResults.setQuestion(null);

		return testResults;
	}

}