package com.chainsys.SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.SpringDemo.dao.UserDAO;
import com.chainsys.SpringDemo.dao.UserImpl;
import com.chainsys.SpringDemo.mapper.UserMapper;
import com.chainsys.SpringDemo.model.User;

public class MyController {
	@Autowired
	UserDAO userDAO;
	UserImpl userImpl;
	UserMapper mapper;
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}

	@GetMapping("/register")
	public String saveUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email) {
		System.out.println("Hello");
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		System.out.println("Hello");
		userImpl.insertUser(user);
		return "success.jsp";
	}

	@PostMapping("/update")
	public String updateUser(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("email") String email) {
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		userImpl.update(user);
		return "success.jsp";
	}

	@GetMapping("/listofusers")
	public String getAllUser(Model model) {
		List<User> users = userImpl.listUsers();
		model.addAttribute("user_list", users);
		return "user.jsp";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
		User user = new User();
		user.setUserId(userId);
		userImpl.deleteUser(user);
		List<User> users = userImpl.listUsers();
		model.addAttribute("users", users);
		return "home.jsp";
	}

	@GetMapping("/findUserbyId")
	public String findUserById(@RequestParam("userId") Integer userId, Model model) {
		System.out.println("finding");
		String name = userImpl.findById(userId);
		System.out.println(name);
		if (name == null) {
			throw new EmptyResultDataAccessException("User not found", userId);
		} else {
			System.out.println("user found" + name);
			model.addAttribute("userFound", name);
		}
		return "success.jsp";
	}

}
