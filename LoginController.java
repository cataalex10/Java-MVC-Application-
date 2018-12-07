package com.mrkobold.dsfinal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkobold.dsfinal.entities.LoginResponse;
import com.mrkobold.dsfinal.entities.User;
import com.mrkobold.dsfinal.services.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
    IUserService userService;  //Service which will do all data retrieval/manipulation work
  
	 @RequestMapping(value = "/login/{name}", method = RequestMethod.GET)
	    public ResponseEntity<User> login(@PathVariable("name") String name,@PathVariable("password") String password) {
		 User currentUser = userService.loginValidate(name, password);
	        if (currentUser==null) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(currentUser,HttpStatus.OK);
	    }

}
