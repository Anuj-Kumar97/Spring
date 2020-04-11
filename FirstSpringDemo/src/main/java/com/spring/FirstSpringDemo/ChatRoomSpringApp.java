package com.spring.FirstSpringDemo;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatRoomSpringApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Beans_Chatroom.xml");
		Map<String,ChatRoomSpring> chat=iocContainer.getBeansOfType(ChatRoomSpring.class);
		for(String key :chat.keySet())
		{
			ChatRoomSpring chatroom=chat.get(key);
			System.out.println(chatroom);
		}
	}

}
