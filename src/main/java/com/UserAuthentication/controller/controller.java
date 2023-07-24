package com.UserAuthentication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserAuthentication.dto.UserDto;
import com.UserAuthentication.entity.User;
import com.UserAuthentication.service.UserService;

@RestController
public class controller {
	
	private static final Logger log = LoggerFactory.getLogger(controller.class);
	
	@GetMapping("/test")
	public String test()
	{
		return " test";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signIn")
	public String saveUser(@RequestBody UserDto user)
	{
		User existing = userService.findByEmail(user.getEmail());
		
		if(existing != null)
		{
			return "There is alreday an user register with this account";
		}
		else {
			userService.saveUser(user);
			return "User Save Successfully";
		}
	}
	
	@GetMapping("/user")
	public List<UserDto> getAllUser()
	{
		return userService.findAllUsers();
	}
	
	
	@GetMapping("/login/{email}/{password}")
	public String getLogin(@PathVariable(value="email") String email,@PathVariable("password") String password )
	{
		
		User auser=userService.findByEmail(email);
		
	   //  log.info("User = {}",auser);
		if(auser!=null)
		{
			String uname=auser.getEmail();
			String upass=auser.getPassword();
		
			if(email.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
			{
				
				return "Login Successfull";
			}
			else 
			{
			return "Your credentails are wrong";
			}
		}
		
		return "Your Email is wrong";
	}
	

}
