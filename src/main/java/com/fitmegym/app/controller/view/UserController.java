package com.fitmegym.app.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitmegym.app.entity.User;
import com.fitmegym.app.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String listUsers(Model model) {
		List<User> users = userService.listUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@PostMapping
	public String addUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/users";
	}

	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
