package com.iter.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.iter.spring.entity.UserEntity;

@Component
public interface UserRepository extends JpaRepository<UserEntity, Long> {
		
		List<UserEntity> findByFirstName(String firstName);
		List<UserEntity> findByOrderByFirstNameAsc();
		List<UserEntity> findByOrderByFirstNameDesc();
		List<UserEntity> findByUserName(String userName);
		List<UserEntity> findBySessionId(String sessionId);

}