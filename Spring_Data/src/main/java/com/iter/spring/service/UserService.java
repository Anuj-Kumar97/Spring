package com.iter.spring.service;

import java.util.List;

import com.iter.spring.json.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getCurrentUserDetails(String id);
	
	public List<User> getUsersByFirstName(String firstName);
	
	public User save(User user);
	
	public User update(User user, String id);
	
	public boolean delete(String id);
	
	public String login(User user);
	
	public User logout(String key);
	
	public List<User> getUserOrdersByFirstNameAsc();
	
	public List<User> getUserOrdersByFirstNameDesc();

}
