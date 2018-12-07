package com.mrkobold.dsfinal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mrkobold.dsfinal.entities.User;


@Repository("userDao")
public class UserDao extends AbstractDao<Integer,User> implements IUserDao {

	@Override
	public User findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveUser(User user) {
		persist(user);	
	}

	@Override
	public void deleteUser(int id) {
		Query query = getSession().createSQLQuery("delete from login where idlogin = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	@Override
	public User findUserByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User login(String name, String password) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));
		return (User)criteria.uniqueResult();
	}
}
