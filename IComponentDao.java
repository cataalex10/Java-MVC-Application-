package com.mrkobold.dsfinal.dao;

import java.util.List;

import com.mrkobold.dsfinal.entities.Component;

public interface IComponentDao {

	Component findById(int id);
	
	void saveComponent(Component component);
	
	void deleteComponent(int id);
	
	List<Component> findAllComponents();
	
	Component findComponentByName(String name);
	
}
