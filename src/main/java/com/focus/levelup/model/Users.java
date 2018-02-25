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
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private int idUser;

	@Temporal(TemporalType.DATE)
	private Date age;

	private int country;

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
	@OneToMany(mappedBy="users")
	private List<Category> categories;

	//bi-directional many-to-one association to Quizze
	@OneToMany(mappedBy="users")
	private List<Quizzes> quizzes;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="users")
	private List<Subscription> subscriptions;

	//bi-directional many-to-one association to Tests
	@OneToMany(mappedBy="users")
	private List<Tests> tests;

	//bi-directional many-to-one association to UserCompany
	@OneToMany(mappedBy="users")
	private List<UserCompany> userCompanies;

	//bi-directional many-to-one association to Roles
	@ManyToOne
	@JoinColumn(name="id_role")
	private Roles roles;

	public Users() {
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

	public int getCountry() {
		return this.country;
	}

	public void setCountry(int country) {
		this.country = country;
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

	public List<Quizzes> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quizzes> quizzes) {
		this.quizzes = quizzes;
	}

	public Quizzes addQuizze(Quizzes quizze) {
		getQuizzes().add(quizze);
		quizze.setUser(this);

		return quizze;
	}

	public Quizzes removeQuizze(Quizzes quizze) {
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

	public List<Tests> getTests() {
		return this.tests;
	}

	public void setTests(List<Tests> tests) {
		this.tests = tests;
	}

	public Tests addTest(Tests tests) {
		getTests().add(tests);
		tests.setUser(this);

		return tests;
	}

	public Tests removeTest(Tests tests) {
		getTests().remove(tests);
		tests.setUser(null);

		return tests;
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

	public Roles getRole() {
		return this.roles;
	}

	public void setRole(Roles roles) {
		this.roles = roles;
	}

}