package com.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstproject.entity.User;
import com.firstproject.service.UserServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UserServiceImpl UserService;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/register")
	public String signup() {
		return "register";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, @RequestParam("img") String img, Model m) {

		user.setImage(img);
		UserService.registerUser(user);

		m.addAttribute("user", user);

		/* return "redirect:/register"; */
		return "success";
	}

}
