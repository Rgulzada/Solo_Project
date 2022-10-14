package com.dojo.java.gulsoftsolution.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.java.gulsoftsolution.models.User;
import com.dojo.java.gulsoftsolution.models.Information;
import com.dojo.java.gulsoftsolution.models.Login;
import com.dojo.java.gulsoftsolution.services.InformationService;
import com.dojo.java.gulsoftsolution.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private InformationService informationServ;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/info")
	public String info(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedListings", informationServ.getUnassignedUsers(userServ.findById(userId)));
		model.addAttribute("assignedListings", informationServ.getAssignedUsers(userServ.findById(userId)));
		 
		return "userInfo.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/";
	}
	
	
	@GetMapping("/informations/new")
	public String newLogin(@ModelAttribute("information") Information information, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "addInfo.jsp";
	}
	
	@PostMapping("/informations/new")
	public String addNewInformation(@Valid @ModelAttribute("information") Information information, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		if(result.hasErrors()) {
			return "addInfo.jsp";
		}else {
			User user = userServ.findById(userId);
			Information newInformation = new Information(information.getName(),
										information.getLastname(),
										information.getSummary(),
										information.getSkills(),
										information.getLead());
			newInformation.setLead(user);
			informationServ.addInformation(newInformation);
			user.getInformations().add(newInformation);
			userServ.updateUser(user);
			return "redirect:/userInfo";
		}
	}
	
	//This is the login and registration page
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new Login());
		return "login.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {

	    User user = userServ.register(newUser, result);
	     
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new Login());
	        return "login.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/userInfo";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") Login newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userServ.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/userInfo";
	}
	
	
}

