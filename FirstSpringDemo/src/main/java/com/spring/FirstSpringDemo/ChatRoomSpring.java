package com.spring.FirstSpringDemo;
import java.util.List;
import java.util.Set;

public class ChatRoomSpring {
	
	private String id;
	private Set<String> users;
	private List<String> messages;
	
	public ChatRoomSpring()
	{
		super();
	}

	public ChatRoomSpring(String id, Set<String> users, List<String> messages) {
		super();
		this.id = id;
		this.users = users;
		this.messages = messages;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "ChatRoomSpring [id=" + id + ", users=" + users + ", messages=" + messages + "]";
	}
	
}
