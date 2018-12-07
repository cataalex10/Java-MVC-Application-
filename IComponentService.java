package com.mrkobold.dsfinal.services;

import com.mrkobold.dsfinal.entities.Component;
import com.mrkobold.dsfinal.entities.User;

import java.util.List;

public interface IComponentService {
	Component findById(int id);
	
	void saveComponent(Component component);
	
	void updateComponent(Component component);
	
	void deleteComponent(int id);
	
	List<Component> findAllComponents();
	
	Component findComponentByName(String name);
	
	
}
