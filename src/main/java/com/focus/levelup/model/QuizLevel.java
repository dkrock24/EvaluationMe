package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the quiz_levels database table.
 * 
 */
@Entity
@Table(name="quiz_levels")
@NamedQuery(name="QuizLevel.findAll", query="SELECT q FROM QuizLevel q")
public class QuizLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_level")
	private int idLevel;

	private Timestamp create;

	private String level;

	private int status;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="id_company")
	private Company company;

	//bi-directional many-to-one association to Quizze
	@OneToMany(mappedBy="quizLevel")
	private List<Quizze> quizzes;

	public QuizLevel() {
	}

	public int getIdLevel() {
		return this.idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}

	public Timestamp getCreate() {
		return this.create;
	}

	public void setCreate(Timestamp create) {
		this.create = create;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Quizze> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quizze> quizzes) {
		this.quizzes = quizzes;
	}

	public Quizze addQuizze(Quizze quizze) {
		getQuizzes().add(quizze);
		quizze.setQuizLevel(this);

		return quizze;
	}

	public Quizze removeQuizze(Quizze quizze) {
		getQuizzes().remove(quizze);
		quizze.setQuizLevel(null);

		return quizze;
	}

}