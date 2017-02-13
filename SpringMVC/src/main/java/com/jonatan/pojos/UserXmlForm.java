package com.jonatan.pojos;

import java.util.ArrayList;

import com.jonatan.tutorial.model.User;

public class UserXmlForm {
	
	ArrayList<User> userList;
	
	public UserXmlForm() {}

	public UserXmlForm(ArrayList<User> userList) {
		super();
		this.userList = userList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
}
