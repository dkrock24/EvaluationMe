package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Roles.findAll", query="SELECT r FROM Roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_role")
	private int idRole;

	private String role;

	private int status;

	//bi-directional many-to-one association to Users
	@OneToMany(mappedBy="roles")
	private List<Users> users;

	public Roles() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users users) {
		getUsers().add(users);
		users.setRole(this);

		return users;
	}

	public Users removeUser(Users users) {
		getUsers().remove(users);
		users.setRole(null);

		return users;
	}

}