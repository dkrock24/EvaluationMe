package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_company")
	private int idCompany;

	private String description;

	private String name;

	private int state;

	private String tel;

	//bi-directional many-to-one association to QuizLevels
	@OneToMany(mappedBy="company")
	private List<QuizLevels> quizLevels;

	//bi-directional many-to-one association to UserCompany
	@OneToMany(mappedBy="company")
	private List<UserCompany> userCompanies;

	public Company() {
	}

	public int getIdCompany() {
		return this.idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<QuizLevels> getQuizLevels() {
		return this.quizLevels;
	}

	public void setQuizLevels(List<QuizLevels> quizLevels) {
		this.quizLevels = quizLevels;
	}

	public QuizLevels addQuizLevel(QuizLevels quizLevels) {
		getQuizLevels().add(quizLevels);
		quizLevels.setCompany(this);

		return quizLevels;
	}

	public QuizLevels removeQuizLevel(QuizLevels quizLevels) {
		getQuizLevels().remove(quizLevels);
		quizLevels.setCompany(null);

		return quizLevels;
	}

	public List<UserCompany> getUserCompanies() {
		return this.userCompanies;
	}

	public void setUserCompanies(List<UserCompany> userCompanies) {
		this.userCompanies = userCompanies;
	}

	public UserCompany addUserCompany(UserCompany userCompany) {
		getUserCompanies().add(userCompany);
		userCompany.setCompany(this);

		return userCompany;
	}

	public UserCompany removeUserCompany(UserCompany userCompany) {
		getUserCompanies().remove(userCompany);
		userCompany.setCompany(null);

		return userCompany;
	}

}