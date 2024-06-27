package com.chainsys.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.demo2.dao.UserImpl;
import com.chainsys.demo2.mapper.UserMapper;
import com.chainsys.demo2.model.User;

@Controller
public class MyController {

	@Autowired
	UserImpl userImpl;
	UserMapper mapper;
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@PostMapping("/register")
	public String saveUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email) {
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		userImpl.insertUser(user);
		return "update.jsp";
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
}
