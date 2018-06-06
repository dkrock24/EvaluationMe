package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tests database table.
 * 
 */
@Entity
@Table(name="tests")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_test")
	private int idTest;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="assigned_dt")
	private Date assignedDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_dt")
	private Date createdDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="finished_dt")
	private Date finishedDt;

	private int status;

	//bi-directional many-to-one association to TestResult
	@OneToMany(mappedBy="test")
	private List<TestResult> testResults;

	//bi-directional many-to-one association to Quizze
	@ManyToOne
	@JoinColumn(name="id_quiz")
	private Quizze quizze;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Test() {
	}

	public int getIdTest() {
		return this.idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public Date getAssignedDt() {
		return this.assignedDt;
	}

	public void setAssignedDt(Date assignedDt) {
		this.assignedDt = assignedDt;
	}

	public Date getCreatedDt() {
		return this.createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getFinishedDt() {
		return this.finishedDt;
	}

	public void setFinishedDt(Date finishedDt) {
		this.finishedDt = finishedDt;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TestResult> getTestResults() {
		return this.testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public TestResult addTestResult(TestResult testResult) {
		getTestResults().add(testResult);
		testResult.setTest(this);

		return testResult;
	}

	public TestResult removeTestResult(TestResult testResult) {
		getTestResults().remove(testResult);
		testResult.setTest(null);

		return testResult;
	}

	public Quizze getQuizze() {
		return this.quizze;
	}

	public void setQuizze(Quizze quizze) {
		this.quizze = quizze;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}