package com.iter.spring.utils;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Consumer;

import com.iter.spring.entity.AdvertiseEntity;
import com.iter.spring.json.Advertise;

public class AdvertiseUtils {
	
	public static List<Advertise> convertAdEntityListToAdJson(List<AdvertiseEntity> adEntityList)
	{
		List<Advertise> adList=new ArrayList<Advertise>();
		Consumer<AdvertiseEntity> consumer=(AdvertiseEntity ad)->adList.add(convertAdEntityToAdJson(ad));
		adEntityList.stream().forEach(consumer);
		return adList;
	}
	
	public static Advertise convertAdEntityToAdJson(AdvertiseEntity adEntity)
	{
		return new Advertise(adEntity.getId(),adEntity.getName(),adEntity.getTitle(),adEntity.getCategory(),
				adEntity.getDescription(),adEntity.getPostID(),adEntity.getStatus(),adEntity.getLdt());
	}
	
	public static AdvertiseEntity convertAdJsonToAdEntity(Advertise adJson)
	{
		return new AdvertiseEntity(adJson.getId(),adJson.getName(),adJson.getTitle(),adJson.getCategory(),
				adJson.getDescription(),adJson.getPostID(),adJson.getStatus(),adJson.getLdt());
	}

}
