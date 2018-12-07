package com.mrkobold.dsfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkobold.dsfinal.dao.ComponentDao;
import com.mrkobold.dsfinal.entities.Component;
import com.mrkobold.dsfinal.entities.User;

@Service("componentService")
@Transactional
public class ComponentService implements IComponentService {
	
	@Autowired
	private ComponentDao dao;
	
	@Override
	public Component findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveComponent(Component component) {
		// TODO Auto-generated method stub
		dao.saveComponent(component);
		
	}

	@Override
	public void updateComponent(Component component) {
		// TODO Auto-generated method stub
		Component entity = dao.findById(component.getIdComponent());
		if (entity != null) {
			entity.setName(component.getName());
			entity.setPrice(component.getPrice());
			entity.setDescription(component.getDescription());
		}
	}

	@Override
	public void deleteComponent(int id) {
		// TODO Auto-generated method stub
		dao.deleteComponent(id);
	}

	@Override
	public List<Component> findAllComponents() {
		return dao.findAllComponents();
	}

	@Override
	public Component findComponentByName(String name) {
		// TODO Auto-generated method stub
		return dao.findComponentByName(name);
	}

}
