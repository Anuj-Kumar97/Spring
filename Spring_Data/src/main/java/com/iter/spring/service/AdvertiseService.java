package com.iter.spring.service;

import java.util.List;

import com.iter.spring.json.Advertise;

public interface AdvertiseService {
		
		public Advertise save(Advertise advertise,String key);
		
		public List<Advertise> getUserAdList(String key);
		
		public List<Advertise> getAllAdvertise();
		
		public String updateAd(String key,Advertise advertise);
		
		public String deleteAd(String key,String id);
		
		public List<Advertise> getAdvertiseByCategory();
		
		public List<String> getCategoryList();
		
		public List<Advertise> getAdvertiseByCategoryForParticularUser(String key);
		
		public List<String> getCategoryListForParticularUser(String key);
		
		public List<Advertise> getAdvertiseByStatus();
		
		public List<Advertise> getAdvertiseByStatusForParticularUser(String key);
		
}
