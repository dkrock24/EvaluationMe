package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	@Temporal(TemporalType.DATE)
	private Date age;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private int status;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="user")
	private List<Category> categories;

	//bi-directional many-to-one association to Quizze
	@OneToMany(mappedBy="user")
	private List<Quizze> quizzes;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="user")
	private List<Subscription> subscriptions;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="user")
	private List<Test> tests;

	//bi-directional many-to-one association to UserCompany
	@OneToMany(mappedBy="user")
	private List<UserCompany> userCompanies;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state")
	private State stateBean;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getAge() {
		return this.age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setUser(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setUser(null);

		return category;
	}

	public List<Quizze> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quizze> quizzes) {
		this.quizzes = quizzes;
	}

	public Quizze addQuizze(Quizze quizze) {
		getQuizzes().add(quizze);
		quizze.setUser(this);

		return quizze;
	}

	public Quizze removeQuizze(Quizze quizze) {
		getQuizzes().remove(quizze);
		quizze.setUser(null);

		return quizze;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setUser(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setUser(null);

		return subscription;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setUser(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setUser(null);

		return test;
	}

	public List<UserCompany> getUserCompanies() {
		return this.userCompanies;
	}

	public void setUserCompanies(List<UserCompany> userCompanies) {
		this.userCompanies = userCompanies;
	}

	public UserCompany addUserCompany(UserCompany userCompany) {
		getUserCompanies().add(userCompany);
		userCompany.setUser(this);

		return userCompany;
	}

	public UserCompany removeUserCompany(UserCompany userCompany) {
		getUserCompanies().remove(userCompany);
		userCompany.setUser(null);

		return userCompany;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public State getStateBean() {
		return this.stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}