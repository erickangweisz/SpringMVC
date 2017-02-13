package com.jonatan.tutorial.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
public class UserList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
