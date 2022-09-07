package com.rest.ws.restfulwebservice.user;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	int usercount = 3;
	static {
		users.add(new User(1, "bo", new Date()));
		users.add(new User(2, "san", new Date()));
		users.add(new User(3, "dee", new Date()));
	}

	public List<User> findAll(){
		return users;
	}
	public User saveUser(User user) {
		if(user.getId() ==null) {
			user.setId(++usercount);
		}
	users.add(user);	
	return user;
	}
	public User findUser(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		//return null;
		return null;
	}
}
