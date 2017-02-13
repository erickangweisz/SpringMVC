package com.jonatan.tutorial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatan.tutorial.model.User;
import com.jonatan.tutorial.model.UserList;

@RestController
public class UserRESTController {

	@RequestMapping(value = "/rest_users")
	public UserList getAllUsers() {
		UserList users = new UserList();
		
		User userBambu = new User("bambu", "bambu123", "normal");
		User userTula = new User("tula", "bambu123", "normal");
		User userSory = new User("sory", "sory123", "admin");
		
		users.getUsers().add(userBambu);
		users.getUsers().add(userTula);
		users.getUsers().add(userSory);
		
		return users;
	}
	
	@RequestMapping(value = "/rest_users/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
		User user = new User("kang", "kang123", "admin");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
