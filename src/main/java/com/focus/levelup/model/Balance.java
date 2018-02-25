package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the balance database table.
 * 
 */
@Entity
@NamedQuery(name="Balance.findAll", query="SELECT b FROM Balance b")
public class Balance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_balance")
	private int idBalance;

	private double create;

	private int state;

	@Column(name="total_months")
	private int totalMonths;

	@Column(name="total_prices")
	private double totalPrices;

	//bi-directional many-to-one association to Subscription
	@ManyToOne
	@JoinColumn(name="id_subscription")
	private Subscription subscription;

	public Balance() {
	}

	public int getIdBalance() {
		return this.idBalance;
	}

	public void setIdBalance(int idBalance) {
		this.idBalance = idBalance;
	}

	public double getCreate() {
		return this.create;
	}

	public void setCreate(double create) {
		this.create = create;
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

	public double getTotalPrices() {
		return this.totalPrices;
	}

	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}