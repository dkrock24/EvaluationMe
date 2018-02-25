package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_userplan")
	private int idUserplan;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private int state;

	@Column(name="total_months")
	private int totalMonths;

	@Column(name="total_price")
	private double totalPrice;

	//bi-directional many-to-one association to Balance
	@OneToMany(mappedBy="subscription")
	private List<Balance> balances;

	//bi-directional many-to-one association to Plane
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plane plane;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users users;

	public Subscription() {
	}

	public int getIdUserplan() {
		return this.idUserplan;
	}

	public void setIdUserplan(int idUserplan) {
		this.idUserplan = idUserplan;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTotalMonths() {
		return this.totalMonths;
	}

	public void setTotalMonths(int totalMonths) {
		this.totalMonths = totalMonths;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setSubscription(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setSubscription(null);

		return balance;
	}

	public Plane getPlane() {
		return this.plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Users getUser() {
		return this.users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

}