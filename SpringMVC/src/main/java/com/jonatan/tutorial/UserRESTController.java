package com.jonatan.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatan.tutorial.model.User;
import com.jonatan.tutorial.model.UserList;
import com.jonatan.tutorial.service.UserService;

@RestController
public class UserRESTController {
	
	private UserService userService;
	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/rest_users")
	public UserList getAllUsers() {
		UserList users = new UserList();
		users.setUsers(userService.listUsers());
		
		return users;
	}
	
	@RequestMapping(value = "/rest_users/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
		User userTemp = userService.getUserByName(name);
		User user = new User(userTemp.getName(), userTemp.getPassword(), userTemp.getType());
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
