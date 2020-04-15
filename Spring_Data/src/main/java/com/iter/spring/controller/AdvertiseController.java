package com.iter.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iter.spring.json.Advertise;
import com.iter.spring.service.AdvertiseService;

	
@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
		
	@Autowired
	private AdvertiseService advertiseService;
		
	@RequestMapping(value="/addad",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Advertise addAdvertise(@RequestBody Advertise advertise,@RequestHeader String key) {
		return advertiseService.save(advertise, key);
	}
	@RequestMapping(value="/updatead",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateAdvertise(@RequestBody Advertise advertise,@RequestHeader String key) {
		return advertiseService.updateAd(key,advertise);
	}
	@RequestMapping(value="/getcategorylist",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCategoryOfAllAdvertise() {
		 return advertiseService.getCategoryList();
	}
	@RequestMapping(value="/getuseradbyid/{id}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getUserAdById(@RequestHeader String id) {
		 return advertiseService.getAdvertiseByCategoryForParticularUser(id);
	}
	@RequestMapping(value="/deletead/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteAdbyId(@RequestHeader String key,@PathVariable(name ="id") String id) {
		 return advertiseService.deleteAd(key, id);
	}
}
