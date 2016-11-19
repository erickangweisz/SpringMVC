package com.jonatan.tutorial.service;

import java.util.List;

import com.jonatan.tutorial.model.User;

public interface UserService {
	
	public void addUser(User u);

	public void updateUser(User u);

	public List<User> listUsers();

	public User getUserByName(String name);

	public void removeUser(String name);
	
}
