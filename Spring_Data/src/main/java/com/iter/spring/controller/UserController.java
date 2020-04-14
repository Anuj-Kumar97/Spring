package com.iter.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iter.spring.json.User;
import com.iter.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService registrationService;
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return registrationService.getAllUsers();
	}
	
	@RequestMapping(value="/register",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User registerUser(@RequestBody User user) {
		return registrationService.save(user);
	}
	
	@GetMapping(value="/getuser",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@RequestHeader(name="auth-token") String authToken) {
			return registrationService.getCurrentUserDetails(authToken);
	}
	
	@PostMapping(value="/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String loginUser(@RequestBody User user){
		return registrationService.login(user);
	}
	
	@DeleteMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
	public User logoutUser(@RequestHeader(name="auth-token") String authToken) {
		return registrationService.logout(authToken);
	}
	
	@PutMapping(value="/user/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable(value="id") String id) {
		return registrationService.update(user, id);
	}
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable(value="id") String id) {
		return registrationService.delete(id);
	}
	
	@GetMapping("/user/firstname/{firstName}")
	public List<User> getUsersByFirstName(@PathVariable(value="firstName") String firstName) {
		return registrationService.getUsersByFirstName(firstName);
	}
	
	@GetMapping("/user/firstname/sort/asc")
	public List<User> getUsersByOrderByFirstNameAsc() {
		return registrationService.getUserOrdersByFirstNameAsc();
	}
	@GetMapping("/user/firstname/sort/desc")
	public List<User> getUsersByOrderByFirstNameDesc() {
		return registrationService.getUserOrdersByFirstNameDesc();
	}

}