package mailApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mailApp.entity.*;
import mailApp.service.MailService;

@Controller
public class UserController {
	
	User user;

	@Autowired
	MailService service;

	@RequestMapping(value={"/", "/home"})
	public String home(Model model, HttpSession session) {
		int userId = 0;
		
		if(session.getAttribute("userId") != null)
			 userId = (int) session.getAttribute("userId");
		
		if(userId != 0) {
			List<Message> messages = service.getMessages(userId);
			
			model.addAttribute("msgList", messages);
			return "index";
		}else {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("msg", "Please login!");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String pass, Model model, HttpSession session) {

		user = service.getUser(username, pass);

		if (user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userId", user.getUserId());
			
			List<Message> messages = service.getMessages(user.getUserId());
			model.addAttribute("msgList", messages);
			return "index";
		}
		
		model.addAttribute("msg", "Invalid username and/or password");
		return "login";
	}
	
	@RequestMapping(value = "/logout") 
	public String logOut(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "you have succesfully logged out.");
		return "login";
	}
	
	@RequestMapping("/msgForm")
	public String msgForm() {
		return "messageForm";
	}
	
	@RequestMapping(value = "/addMsg", method = RequestMethod.POST)
	public String addMsg(@RequestParam("msg") String msg, Model model, HttpSession session) {
		boolean isAdded = service.addMessages((int) session.getAttribute("userId"), msg);
		model.addAttribute("isAdded", isAdded);
		if(!isAdded) model.addAttribute("hasError", true);
		return "messageForm";
	}
	
}
