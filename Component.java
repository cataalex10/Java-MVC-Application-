package com.mrkobold.dsfinal.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "component")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idcomponent;
	private String name;
	private double price;
	private String description;
	
	public Component() {};
	
	public Component(Integer idcomponent, String name, double price, String description) {
		super();
		this.idcomponent = idcomponent;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcomponent", unique = true, nullable = false)
	public Integer getIdComponent() {
		return this.idcomponent;
	}
	public void setIdComponent(Integer idcomponent) {
		this.idcomponent = idcomponent;
	}
	
	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "price", nullable = false)
	public double getPrice(){
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "description", nullable = false, length = 45)
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
