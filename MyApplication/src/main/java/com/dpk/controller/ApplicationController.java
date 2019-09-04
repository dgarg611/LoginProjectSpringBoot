package com.dpk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpk.model.User;
import com.dpk.service.UserService;


@Controller
public class ApplicationController {
	 
	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request)
	{
		userService.saveMyUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "welcomepage";
	}
	@PostMapping("/save-user2")
	public String registerUser2(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request)
	{
		userService.saveMyUser(user);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request)
	{
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		request.setAttribute("mode","MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String userLogin(HttpServletRequest request)
	{
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String deleteTheUser(@RequestParam int id, HttpServletRequest request)
	{
		userService.deleteMyUser(id);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
}
