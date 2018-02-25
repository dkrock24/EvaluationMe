package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_company database table.
 * 
 */
@Entity
@Table(name="user_company")
@NamedQuery(name="UserCompany.findAll", query="SELECT u FROM UserCompany u")
public class UserCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user_company")
	private int idUserCompany;

	@Temporal(TemporalType.TIMESTAMP)
	private Date create;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="id_company")
	private Company company;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users users;

	public UserCompany() {
	}

	public int getIdUserCompany() {
		return this.idUserCompany;
	}

	public void setIdUserCompany(int idUserCompany) {
		this.idUserCompany = idUserCompany;
	}

	public Date getCreate() {
		return this.create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Users getUser() {
		return this.users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

}