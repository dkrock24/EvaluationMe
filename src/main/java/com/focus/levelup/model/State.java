package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the states database table.
 * 
 */
@Entity
@Table(name="states")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_state")
	private int idState;

	@Column(name="lat_state")
	private String latState;

	@Column(name="long_state")
	private String longState;

	@Column(name="name_state")
	private String nameState;

	@Column(name="shourtcut_state")
	private String shourtcutState;

	private int status;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="id_country")
	private Country country;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="stateBean")
	private List<User> users;

	public State() {
	}

	public int getIdState() {
		return this.idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public String getLatState() {
		return this.latState;
	}

	public void setLatState(String latState) {
		this.latState = latState;
	}

	public String getLongState() {
		return this.longState;
	}

	public void setLongState(String longState) {
		this.longState = longState;
	}

	public String getNameState() {
		return this.nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public String getShourtcutState() {
		return this.shourtcutState;
	}

	public void setShourtcutState(String shourtcutState) {
		this.shourtcutState = shourtcutState;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setStateBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setStateBean(null);

		return user;
	}

}