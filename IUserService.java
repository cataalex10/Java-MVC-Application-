package com.mrkobold.dsfinal.services;

import java.util.List;

import com.mrkobold.dsfinal.entities.User;



public interface IUserService {
	User findById(int id);
	
	void saveUser(User User);
	
	void updateUser(User User);
	
	void deleteUser(int id);

	List<User> findAllUsers(); 
	
	User findUserByName(String name);
	User loginValidate(String name,String password);

}
