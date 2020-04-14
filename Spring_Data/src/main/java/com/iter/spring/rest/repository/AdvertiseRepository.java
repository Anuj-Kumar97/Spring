package com.iter.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iter.spring.entity.AdvertiseEntity;
import com.iter.spring.entity.UserEntity;

public interface AdvertiseRepository extends JpaRepository<AdvertiseEntity, Long> {
		
		List<AdvertiseEntity> findByName(String name);
		List<AdvertiseEntity> findByOrderByNameAsc();
		List<AdvertiseEntity> findByOrderByNameDesc();
		List<AdvertiseEntity> findById(long id);
		List<AdvertiseEntity> findByStatus(String status);
		List<AdvertiseEntity> findByPostId(long postId);

}