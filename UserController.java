package com.mrkobold.dsfinal.controller;

import java.util.List;

import com.mrkobold.dsfinal.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.mrkobold.dsfinal.entities.LoginResponse;
import com.mrkobold.dsfinal.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    IUserService userService;  //Service which will do all data retrieval/manipulation work
  
	@RequestMapping(value = "/user/{name,password}", method = RequestMethod.GET)
	public ResponseEntity<User> login(@PathVariable("name") String name,@PathVariable("password") String password) {
		 User currentUser = userService.loginValidate(name, password);
		 
		 if (currentUser==null) {
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
	     return new ResponseEntity<User>(currentUser,HttpStatus.OK);
	}
	//-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
  //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
  
        if (userService.findUserByName(user.getName())!=null) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userService.saveUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  //------------------- Update a User --------------------------------------------------------
    
    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        System.out.println("Updating User " + id);
          
        User currentUser = userService.findById(id);
          
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        currentUser.setName(user.getName());
        currentUser.setPassword(user.getPassword());
        currentUser.setPriviledge(user.getPriviledge());
          
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@RequestBody int id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
