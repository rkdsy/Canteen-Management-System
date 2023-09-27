package com.canteen.controller;





import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.canteen.entity.UserDtls;
import com.canteen.repository.UserRepository;

import jakarta.servlet.http.HttpSession;




@Controller
public class HomeController {
	
	
	

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}


	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute UserDtls user, Model m,HttpSession session) {
		
		
		
		UserDtls u=userRepo.save(user);
		if(u!=null) {
			session.setAttribute("msg", "Register Sucessfully");
		}
		else {
		session.setAttribute("msg", "Something wrong on server ");
		}
		return "redirect:/signup";
	}

}