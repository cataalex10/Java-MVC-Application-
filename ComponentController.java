package com.mrkobold.dsfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.mrkobold.dsfinal.entities.Component;
import com.mrkobold.dsfinal.services.IComponentService;

@Controller
@RequestMapping("/component")
public class ComponentController {
	@Autowired
    IComponentService componentService;  //Service which will do all data retrieval/manipulation work
  
	//-------------------Retrieve All Components--------------------------------------------------------
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Component>> listAllComponents() {
        List<Component> components = componentService.findAllComponents();
        if(components.isEmpty()) {
            return new ResponseEntity<List<Component>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Component>>(components, HttpStatus.OK);
    }
  //-------------------Create a Component--------------------------------------------------------
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createComponent(@RequestBody Component component,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Component" + component.getName());
  
        if (componentService.findComponentByName(component.getName())!=null) {
            System.out.println("A Component with name " + component.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        componentService.saveComponent(component);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/component/{id}").buildAndExpand(component.getIdComponent()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  //------------------- Update a Component --------------------------------------------------------
    
    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public ResponseEntity<Component> updateComponent(@PathVariable("id") int id, @RequestBody Component component) {
        System.out.println("Updating Component " + id);
          
        Component currentComponent= componentService.findById(id);
          
        if (currentComponent == null) {
            System.out.println("Component with id " + id + " not found");
            return new ResponseEntity<Component>(HttpStatus.NOT_FOUND);
        }
  
        currentComponent.setName(component.getName());
        currentComponent.setPrice(component.getPrice());
        currentComponent.setDescription(component.getDescription());
          
        componentService.updateComponent(currentComponent);
        return new ResponseEntity<Component>(currentComponent, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Component --------------------------------------------------------
      
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Component> deleteComponent (@RequestBody int id) {
        System.out.println("Fetching & Deleting Component with id " + id);
  
        Component component= componentService.findById(id);
        if (component == null) {
            System.out.println("Unable to delete. Componet with id " + id + " not found");
            return new ResponseEntity<Component>(HttpStatus.NOT_FOUND);
        }
  
        componentService.deleteComponent(id);
        return new ResponseEntity<Component>(HttpStatus.NO_CONTENT);
    }
}
