package com.jonatan.tutorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jonatan.tutorial.model.User;
import com.jonatan.tutorial.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView("usersList");

		mav.addObject("user", new User());
		mav.addObject("userList", this.userService.listUsers());
		
		return mav;
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User u) {
		ModelAndView mav = new ModelAndView("redirect:/users");
		
		List<User> uList = this.userService.listUsers();
		
		for (User user : uList) {
			if(u.getName().equals(user.getName())) {
				this.userService.updateUser(u);
				return mav;
			}
		}
		
		this.userService.addUser(u);
		return mav;
	}
	
	@RequestMapping("/remove/{name}")
	public ModelAndView removeUser(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("redirect:/users");
		this.userService.removeUser(name);
		
		return mav;
	}
	
	@RequestMapping("/edit/{name}")
	public ModelAndView editUser(@PathVariable("name") String name){
		ModelAndView mav = new ModelAndView("usersList");
		mav.addObject("user", this.userService.getUserByName(name));
		mav.addObject("userList", this.userService.listUsers());
		
		return mav;
	}
	
	@RequestMapping("/viewuser/{name}")
	public ModelAndView viewUser(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("viewusers");
		mav.addObject("user", this.userService.getUserByName(name));
		
		return mav;
	}
	
}
