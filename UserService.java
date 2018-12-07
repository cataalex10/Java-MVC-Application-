package com.mrkobold.dsfinal.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkobold.dsfinal.dao.UserDao;
import com.mrkobold.dsfinal.entities.User;


@Service("userService")
@Transactional
public class UserService implements IUserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public User findById(int id) {
		return dao.findById(id);
	}
	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	@Override
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setName(user.getName());
			entity.setPassword(user.getPassword());
			entity.setPriviledge(user.getPriviledge());
		}
	}
	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}
	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	@Override
	public User findUserByName(String name) {
		return dao.findUserByName(name);
	}
	@Override
	public User loginValidate(String name, String password) {
		
		return dao.login(name, password);
	}


}
