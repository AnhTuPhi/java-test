package com.java.container.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.container.entity.User;
import com.java.container.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(value = {"/" }, method = RequestMethod.GET )
	public String index() {
		System.out.println("Index");
		return "index";
	}
	
	@RequestMapping(value = {"/register" }, method = RequestMethod.GET )
	public String registerLoadForm(Model model) {
		//create model to bind data from entity
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = {"/register" }, method = RequestMethod.POST )
	public String registerUser(@ModelAttribute("user") User user) {
		//save data User to database
		repo.save(user);
		return "redirect:/";
	}
}
