package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company_user database table.
 * 
 */
@Entity
@Table(name="company_user")
@NamedQuery(name="CompanyUser.findAll", query="SELECT c FROM CompanyUser c")
public class CompanyUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int company;

	private int user;

	public CompanyUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompany() {
		return this.company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

}