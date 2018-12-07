package com.mrkobold.dsfinal.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idorder;
	private Integer delivered;
	private Integer buyer;
	private Date orderdate;
	
	public Order(){};
	
	public Order(Integer idorder, Integer delivered, Integer buyer, Date orderdate) {
		super();
		this.idorder = idorder;
		this.delivered = delivered;
		this.buyer = buyer;
		this.orderdate = orderdate;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idorder", unique = true, nullable = false)
	public Integer getIdOrder() {
		return this.idorder;
	}
	public void setIdOrder(Integer idorder) {
		this.idorder = idorder;
	}
	
	@Column(name = "delivered", nullable = false)
	public Integer getDelivered() {
		return this.delivered;
	}
	public void setDelivered(Integer delivered) {
		this.delivered = delivered;
	}
	
	@Column(name = "buyer", nullable = false)
	public Integer getBuyer() {
		return this.buyer;
	}
	public void setBuyer(Integer buyer) {
		this.buyer = buyer;
	}
	
	@Column(name = "orderdate", nullable = false)
	public Date getOrderDate() {
		return this.orderdate;
	}
	public void setOrderDate(Date orderdate) {
		this.orderdate = orderdate;
	}
	

}
