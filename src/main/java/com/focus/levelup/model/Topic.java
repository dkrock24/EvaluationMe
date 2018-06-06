package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topics database table.
 * 
 */
@Entity
@Table(name="topics")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_topic")
	private int idTopic;

	private int create;

	private String description;

	private String name;

	private int status;

	//bi-directional many-to-one association to Quizze
	@OneToMany(mappedBy="topic")
	private List<Quizze> quizzes;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	public Topic() {
	}

	public int getIdTopic() {
		return this.idTopic;
	}

	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}

	public int getCreate() {
		return this.create;
	}

	public void setCreate(int create) {
		this.create = create;
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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Quizze> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quizze> quizzes) {
		this.quizzes = quizzes;
	}

	public Quizze addQuizze(Quizze quizze) {
		getQuizzes().add(quizze);
		quizze.setTopic(this);

		return quizze;
	}

	public Quizze removeQuizze(Quizze quizze) {
		getQuizzes().remove(quizze);
		quizze.setTopic(null);

		return quizze;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}