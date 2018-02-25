package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the quizzes database table.
 * 
 */
@Entity
@Table(name="quizzes")
@NamedQuery(name="Quizze.findAll", query="SELECT q FROM Quizzes q")
public class Quizzes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_quiz")
	private int idQuiz;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private int status;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to Questions
	@OneToMany(mappedBy="quizze")
	private List<Questions> questions;

	//bi-directional many-to-one association to QuizLevels
	@ManyToOne
	@JoinColumn(name="id_level")
	private QuizLevels quizLevels;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="id_topic")
	private Topic topic;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_amin")
	private Users users;

	//bi-directional many-to-one association to Tests
	@OneToMany(mappedBy="quizze")
	private List<Tests> tests;

	public Quizzes() {
	}

	public int getIdQuiz() {
		return this.idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Questions> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public Questions addQuestion(Questions questions) {
		getQuestions().add(questions);
		questions.setQuizze(this);

		return questions;
	}

	public Questions removeQuestion(Questions questions) {
		getQuestions().remove(questions);
		questions.setQuizze(null);

		return questions;
	}

	public QuizLevels getQuizLevel() {
		return this.quizLevels;
	}

	public void setQuizLevel(QuizLevels quizLevels) {
		this.quizLevels = quizLevels;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Users getUser() {
		return this.users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public List<Tests> getTests() {
		return this.tests;
	}

	public void setTests(List<Tests> tests) {
		this.tests = tests;
	}

	public Tests addTest(Tests tests) {
		getTests().add(tests);
		tests.setQuizze(this);

		return tests;
	}

	public Tests removeTest(Tests tests) {
		getTests().remove(tests);
		tests.setQuizze(null);

		return tests;
	}

}