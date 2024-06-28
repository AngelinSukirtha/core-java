package com.chainsys.SpringDemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.SpringDemo.dao.UserDAO;
import com.chainsys.SpringDemo.model.User;

@Controller
public class MyController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}

	@GetMapping("/register")
	public String saveUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email) {
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		userDAO.insertUser(user);
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
		userDAO.update(user);
		return "success.jsp";
	}

	@GetMapping("/listofusers")
	public String getAllUser(Model model) {
		List<User> users = userDAO.listUsers();
		model.addAttribute("user_list", users);
		return "user.jsp";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
		User user = new User();
		user.setUserId(userId);
		user.setStatus(false);
		userDAO.deleteUser(user);
		List<User> users = userDAO.listUsers();
		model.addAttribute("users", users);
		return "home.jsp";
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchText") String searchText, Model model) {
		List<User> users = userDAO.search(searchText);
		model.addAttribute("user_list", users);
		return "user.jsp";
	}

}
