package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planes database table.
 * 
 */
@Entity
@Table(name="planes")
@NamedQuery(name="Plane.findAll", query="SELECT p FROM Plane p")
public class Plane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_plan")
	private int idPlan;

	@Lob
	private String description;

	private String name;

	private double price;

	private int state;

	//bi-directional many-to-one association to PlanesDetail
	@OneToMany(mappedBy="plane")
	private List<PlanesDetail> planesDetails;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="plane")
	private List<Subscription> subscriptions;

	public Plane() {
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<PlanesDetail> getPlanesDetails() {
		return this.planesDetails;
	}

	public void setPlanesDetails(List<PlanesDetail> planesDetails) {
		this.planesDetails = planesDetails;
	}

	public PlanesDetail addPlanesDetail(PlanesDetail planesDetail) {
		getPlanesDetails().add(planesDetail);
		planesDetail.setPlane(this);

		return planesDetail;
	}

	public PlanesDetail removePlanesDetail(PlanesDetail planesDetail) {
		getPlanesDetails().remove(planesDetail);
		planesDetail.setPlane(null);

		return planesDetail;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setPlane(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setPlane(null);

		return subscription;
	}

}