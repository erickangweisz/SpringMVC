package com.jonatan.tutorial.dao;

import java.util.List;

import com.jonatan.tutorial.model.User;

public interface UserDAO {

	public void addUser(User u);

	public void updateUser(User u);

	public List<User> listUsers();

	public User getUserByName(String name);

	public void removeUser(String name);

}
