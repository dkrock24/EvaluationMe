package com.focus.levelup.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planes_detail database table.
 * 
 */
@Entity
@Table(name="planes_detail")
@NamedQuery(name="PlanesDetail.findAll", query="SELECT p FROM PlanesDetail p")
public class PlanesDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detail")
	private int idDetail;

	@Column(name="item_detail")
	private String itemDetail;

	private int order;

	private int state;

	//bi-directional many-to-one association to Plane
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plane plane;

	public PlanesDetail() {
	}

	public int getIdDetail() {
		return this.idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public String getItemDetail() {
		return this.itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Plane getPlane() {
		return this.plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}