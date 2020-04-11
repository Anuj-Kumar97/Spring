package com.spring.SpringRestDemo;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private long phone;
	
	List<Advertise> adlist=new ArrayList<Advertise>();
	
	public User() {}

	public User(String firstname, String lastname, String username, String password, String email, long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Advertise> getAdlist() {
		return adlist;
	}

	public void setAdlist(Advertise advertise) {
		this.adlist.add(advertise);
	}
	
	public boolean deleteAdvertiseList(Advertise advertise)
	{
		if(this.adlist.contains(advertise))
		{
			this.adlist.remove(advertise);
			return true;
		}
		return false;
	}
	
	public boolean updateExistingAdvertise(Advertise advertise)
	{
		if(this.adlist.contains(advertise))
		{
			this.adlist.remove(advertise);
			this.setAdlist(advertise);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phone=" + phone + ", adlist=" + adlist + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
