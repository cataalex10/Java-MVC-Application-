package com.mrkobold.dsfinal.dao;

import java.util.List;

import com.mrkobold.dsfinal.entities.User;


public interface IUserDao {

	User findById(int id);

	void saveUser(User user);
	
	void deleteUser(int id);
	
	List<User> findAllUsers(); 

	User findUserByName(String name);
	
	User login(String name, String password);
}
