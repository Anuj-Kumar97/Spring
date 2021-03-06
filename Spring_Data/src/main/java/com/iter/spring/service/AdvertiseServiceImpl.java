package com.iter.spring.service;

import java.util.List;

import com.iter.spring.json.Advertise;

public class AdvertiseServiceImpl implements AdvertiseService {

	@Override
	public Advertise save(Advertise advertise, String key) {
		
		UserEntity userEntity=this.getBySessionId(key);
		if(userEntity!=null){	
			AdvertiseEntity adv=AdvertiseUtils.convertAdJsonToAdEntity(advertise);
			adv.setLdt(LocalDateTime.now());
			adv.setUserEntity(userEntity);
			advertiseRepository.save(adv);
			return AdvertiseUtils.convertAdEntityToAdJson(adv);
		}
		else{
			return null;
		}
	}

	@Override
	public List<Advertise> getUserAdList(String key) {
		
		UserEntity userEntity=this.getBySessionId(key);
		if(userEntity!=null){
			return AdvertiseUtils.convertAdEntityListToAdJson(userEntity.getAdEntity());
		}
		else{
			return null;
		}
	}

	@Override
	public List<Advertise> getAllAdvertise() {
		return AdvertiseUtils.convertAdEntityListToAdJson(advertiseRepository.findAll());
	}

	@Override
	public String updateAd(String key, Advertise advertise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAd(String key, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> getAdvertiseByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> getAdvertiseByCategoryForParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCategoryListForParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> getAdvertiseByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertise> getAdvertiseByStatusForParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  UserEntity getBySessionId(String key)
	{
		if(key==null||key.equals(""))
		{
			return null;
		}
		UserEntity userentity=userRepository.findBySessionId(key).get(0);
		if(userentity==null)
		{
			return null;
		}
		else
		{
			return userentity;
		}
	}
	
}
