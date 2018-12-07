package com.mrkobold.dsfinal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mrkobold.dsfinal.entities.Component;

@Repository("componentDao")
public class ComponentDao extends AbstractDao<Integer, Component> implements IComponentDao {

	@Override
	public Component findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveComponent(Component component) {
		persist(component);
	}

	@Override
	public void deleteComponent(int id) {
		Query query = getSession().createSQLQuery("delete from component where idcomponent = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Component> findAllComponents() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Component.class);
		return (List<Component>) criteria.list();
	}

	@Override
	public Component findComponentByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eqOrIsNull("name", name));
		return (Component)criteria.uniqueResult();
	}

}
