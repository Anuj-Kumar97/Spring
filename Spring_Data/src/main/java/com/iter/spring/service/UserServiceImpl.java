package com.iter.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iter.spring.entity.UserEntity;
import com.iter.spring.json.User;
import com.iter.spring.rest.repository.UserRepository;
import com.iter.spring.utils.UserUtils;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String login(User user)
	{
		String userName=user.getUserName();
		String password=user.getPassword();
		List<UserEntity> userList=userRepository.findByUserName(userName);
		if(userList==null||userList.size()==0)
		{
			return "{ \"result\": \"failed\",\"message\":\"Invalid user\""+userName+"}";
		}
		else {
			UserEntity userEntity=userList.get(0);
			if(password.equals(userEntity.getPassword())) {
				String sessionId=new java.rmi.server.UID().toString().substring(0,10);
				userEntity.setSessionId(sessionId);
				userRepository.save(userEntity);
				return "{ \"result\":\"success\",\"message\": \"Login successful\",auth-token\":\""+sessionId+"\"}";
			}
			else {
				return "{ \"result\": \"failed\",\"message\": \"Invalid Password\" }";
			}
		}
	}
	
	@Override
	public List<User> getAllUsers() {
		List<UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}
	
	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<UserEntity> userEntityList = userRepository.findByFirstName(firstName);
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public User getCurrentUserDetails(String id) {
		UserEntity userEntity = userRepository.findBySessionId(id).get(0);
		return UserUtils.convertUserEntityToUser(userEntity);	
	}

	@Override
	public User save(User user) {
		UserEntity userEntity = 
				userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	@Override
	public User update(User user,String id) {
		UserEntity userEntity = userRepository.findById(user.getId()).get();
		if(userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity.setEmail(user.getEmail());
			userEntity.setPhone(user.getPhone());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		if(userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}
	
	@Override
	public User logout(String key) {
		UserEntity user=userRepository.findBySessionId(key).get(0);
		user.setSessionId(null);
		UserEntity userEntity=userRepository.save(user);	
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	@Override
	public List<User> getUserOrdersByFirstNameAsc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameAsc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	@Override
	public List<User> getUserOrdersByFirstNameDesc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameDesc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}
	
}