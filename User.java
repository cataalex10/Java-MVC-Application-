package com.mrkobold.dsfinal.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String password;
	private String priviledge;
	
	public User(){};
	
	public User(Integer id, String name,String password,String priviledge) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.priviledge =priviledge;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idlogin", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    @Column(name = "username", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "role",nullable = false, length = 100)
	public String getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}
	@Column(name = "password",nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
