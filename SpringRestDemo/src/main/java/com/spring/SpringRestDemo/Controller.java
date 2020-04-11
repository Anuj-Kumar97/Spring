package com.spring.SpringRestDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertise")
public class Controller {
	
	List<User> userMasterList=new ArrayList<User>();
	Map<String,User>  loggedUserMap=new HashMap<String,User>();
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String loginUser(@RequestBody JsonStringCheck userNameAndPassword)
	{	
		if(!(userNameAndPassword==null))
		{
			Optional<User> userApiStream=userMasterList.stream().filter((User userCheck)-> userNameAndPassword.getInput1().equals(userCheck.getUsername())&&userNameAndPassword.getInput2().equals(userCheck.getPassword())).findAny();
			if(userApiStream.isPresent())
			{
				User loggingInUser=userMasterList.stream().filter((User userCheck)-> userNameAndPassword.getInput1().equals(userCheck.getUsername())&&userNameAndPassword.getInput2().equals(userCheck.getPassword())).collect(Collectors.toList()).get(0);
				loggedUserMap.put((loggingInUser.getUsername()+loggingInUser.getPhone()).toLowerCase(),loggingInUser);
				return "Succesfully LoggedIn";
			}
		}
		return "Authentication failed";
	}
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody User user)
	{	
		if(!(user==null))
		{
			Stream<User> userApiStream=userMasterList.stream().filter((User userCheck)-> user.equals(userCheck));
			if(!(userApiStream.findAny().isPresent()&&user.getUsername().equals("")&&user.getPassword().equals("")))
			{
				userMasterList.add(user);
				return "Succesfully Registerd";
			}
			else
			{
				return "UserName Already exists";
			}
		}
		return "Authentication failed";
	}
	@PostMapping(value="/addadvertise", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addAdvertise(@RequestBody Advertise advertisement,@RequestHeader(name="authToken") String authToken)
	{
		if(authToken==null)
		{
			return "{\"result\": \"Auth-token is mandatory\"}";
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			User user=loggedUserMap.get(authToken);
			user.setAdlist(advertisement);
			return "Advertisement "+advertisement.toString()+" added to user "+user.getUsername()+" succesfully";
		}
		else
		{
			return "LogIn or register to continue";
		}
	}
	@GetMapping(value="/getuserlist",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUserInfo()
	{
		return this.userMasterList;
	}
	
	@GetMapping(value="/getadvofuser",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getUserAdvertisementList(@RequestHeader(name="auth-token") String authToken)
	{
		if(authToken==null)
			return null;
		if(loggedUserMap.containsKey(authToken))
		{
			User user=loggedUserMap.get(authToken);
			return user.getAdlist();
		}
		else
			return null;
	}
	
	@PostMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
	public String logOut(@RequestHeader(name="authToken") String authToken)
	{
		if(authToken==null)
		{
			return "{\"result\": \"Auth-token is mandatory\"}";
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			User userToBeDeleted=loggedUserMap.get(authToken);
			loggedUserMap.remove(authToken);
			return " Logged Out  user "+userToBeDeleted.getUsername()+" succesfully";
		}
		else
		{
			return "LogIn or register to continue";
		}
	}
	
	public User checkLoggedInUser(String authToken)
	{

		if(authToken==null)
		{
			return null;
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			User user=loggedUserMap.get(authToken);
			return user;
		}
		else
		{
			return null;
		}

	}
	
	@PutMapping(value="/updateadv",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateAdvertisementOfUser(@RequestBody Advertise advertisement,@RequestHeader(name="authToken") String authToken)
	{
		User user=checkLoggedInUser(authToken);
		if(user==null)
		{
			return "LogIn or register to continue";
		}
		else
		{	
			
			if(advertisement!=null &&((!advertisement.getName().equals(""))||advertisement.getName()!=null))
			{	
				if(user.getAdlist().stream().filter((Advertise adv)->adv.equals(advertisement)).findAny().isPresent())
				{
					Advertise updateAdvertisement=user.getAdlist().stream().filter((Advertise adv)->adv.equals(advertisement)).collect(Collectors.toList()).get(0);
					user.deleteAdvertiseList(updateAdvertisement);
					user.setAdlist(advertisement);
					return "Advertisement updated succesfully";
				}
				else
				{
					return "No advertisement of name "+ advertisement.getName()+" is present";
				}
			}
			else
			{
				return "advertisement "+ advertisement+" should have a valid name";
			}
			
		}
	}
	
	@GetMapping(value = "/getpartadvofuser",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertise> getAUserParticularAdvertisementLsit(@RequestHeader(name="authToken") String authToken,@RequestParam(name="advname") String advName)
	{	
		User user=checkLoggedInUser(authToken);
		if(user == null)
		{
			return null;
		}
		else
		{
			if(advName==null||advName.equals(""))
			{
				return null;
			}
			else
			{
				return user.getAdlist().stream().filter((Advertise advertisement)->advertisement.getName().equals(advName)).collect(Collectors.toList());
			}
		}
	}
	
	@DeleteMapping(value = "/delpartadvofuser/{advname}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteAUserParticularAdvertisementLsit(@RequestHeader(name="authToken") String authToken,@PathVariable(name="advname") String advName)
	{	
		User user=checkLoggedInUser(authToken);
		if(user == null)
		{
			return "Log in to continue";
		}
		else
		{
			if(advName==null||advName.equals(""))
			{
				return "Give a valid advertisement name";
			}
			else
			{
				Advertise adv= user.getAdlist().stream().filter((Advertise advertisement)->advertisement.getName().equals(advName)).collect(Collectors.toList()).get(0);
				user.deleteAdvertiseList(adv);
				return "advertisement adv "+adv+" from user "+user+" deleted succesfully";
			}
		}
	}
	
	@GetMapping(value = "/getdetailsofuser",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAUserDetails(@RequestHeader(name="authToken") String authToken)
	{	
		User user=checkLoggedInUser(authToken);
		if(user == null)
		{
			return "Log in to continue";
		}
		else
		{
			return user.toString();
		}
	}

}
