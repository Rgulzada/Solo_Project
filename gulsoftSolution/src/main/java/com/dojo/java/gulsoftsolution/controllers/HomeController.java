package com.dojo.java.gulsoftsolution.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.java.gulsoftsolution.models.User;
import com.dojo.java.gulsoftsolution.models.Information;
import com.dojo.java.gulsoftsolution.models.Login;
import com.dojo.java.gulsoftsolution.models.Task;
import com.dojo.java.gulsoftsolution.services.InformationService;
import com.dojo.java.gulsoftsolution.services.TaskService;
import com.dojo.java.gulsoftsolution.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	
	@Autowired
	private InformationService informationServ;
	
	@Autowired
	private TaskService taskServ;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/career";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedInformations", informationServ.getUnassignedUsers(userServ.findById(userId)));
		model.addAttribute("assignedInformations", informationServ.getAssignedUsers(userServ.findById(userId)));
		 
		return "userInfo.jsp";
	}
	@RequestMapping("/dashboard/join/{id}")
	public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Information information = informationServ.findById(id);
		User user = userServ.findById(userId);
		
		user.getInformations().add(information);
		userServ.updateUser(user);
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedInformations", informationServ.getUnassignedUsers(user));
		model.addAttribute("assignedInformations", informationServ.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Information information = informationServ.findById(id);
		User user = userServ.findById(userId);
		
		user.getInformations().remove(information);
		userServ.updateUser(user);
		
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("unassignedInformations", informationServ.getUnassignedUsers(user));
		model.addAttribute("assignedInformations", informationServ.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/informations/{id}")
	public String viewInformation(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Information information = informationServ.findById(id);
		model.addAttribute("information", information);
		return "view_information.jsp";
	}
	
	@GetMapping("/informations/edit/{id}")
	public String openEditInformation(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Information information = informationServ.findById(id);
		model.addAttribute("information", information);
		return "edit_information.jsp";
	}
	
	@PostMapping("/informations/edit/{id}")
	public String editInformation(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("information") Information information, 
			BindingResult result, 
			HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userServ.findById(userId);
		
		if(result.hasErrors()) {
			return "edit_information.jsp";
		}else {
			Information thisInformation = informationServ.findById(id);
			information.setUsers(thisInformation.getUsers());
			information.setLead(user);
			informationServ.updateInformation(information);
			return "redirect:/dashboard";
		}
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
	@GetMapping("/career")
	public String career(Model model) {
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
	 
	    return "redirect:/dashboard";
	}
	
	@PostMapping("/loginuser")
	public String loginuser(@Valid @ModelAttribute("newLogin") Login newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userServ.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/dashboard";
	}
	
	//--------------To Delete---------
	@RequestMapping("/informations/delete/{id}")
	public String deleteInformation(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userServ.findById(userId);
		
		Information information = informationServ.findById(id);
		
		// We need to make sure all tasks associated with the information we are deleting are deleted first
		for(Task t:taskServ.infoTasks(id)) {
			taskServ.deleteTask(t);
		}
		
		// Once the tasks are deleted, we can safely delete our information
		informationServ.deleteInformation(information);
		model.addAttribute("unassignedInformations", informationServ.getUnassignedUsers(user));
		model.addAttribute("assignedInformations", informationServ.getAssignedUsers(user));
		return "redirect:/home";
	}

}

