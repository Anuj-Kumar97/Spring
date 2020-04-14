package com.iter.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.iter.spring.entity.UserEntity;
import com.iter.spring.json.User;

public class UserUtils {

	public static List<User> convertUserEntityListToUserList(List<UserEntity> userEntityList) {
		List<User> userList = new ArrayList<User>();
		Consumer<UserEntity> consumer = ((UserEntity userEntity)->userList.add(convertUserEntityToUser(userEntity)));
		userEntityList.stream().forEach(consumer);
		return userList;
	}
	
	public static User convertUserEntityToUser(UserEntity userEntity) {
		return new User(userEntity.getId(), userEntity.getUserName(), userEntity.getFirstName(), 
				userEntity.getLastName(),userEntity.getPassword(),userEntity.getEmail(),userEntity.getPhone());
	}

	public static UserEntity convertUserToUserEntity(User user) {
		return new UserEntity(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(),
				user.getPassword(),user.getEmail(),user.getPhone());
	}
}
