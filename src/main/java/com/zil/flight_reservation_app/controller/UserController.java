package com.zil.flight_reservation_app.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zil.flight_reservation_app.entity.User;
import com.zil.flight_reservation_app.service.UserService;

@Controller
public class UserController {

	Pattern pattern = Pattern.compile("\\S");

	@Autowired
	private UserService userService;

	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
	}

	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user, ModelMap modelMap) {

		if (pattern.matcher(user.getFirstName()).find() != false 
				&& pattern.matcher(user.getLastName()).find() != false
				&& pattern.matcher(user.getEmail()).find() != false
				&& pattern.matcher(user.getPassword()).find() != false) {
			
			userService.saveUser(user);
			return "login/login";
		}	
		modelMap.addAttribute("errorMsg", "Please fill all the required fields");
		return "login/showReg";		
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		Boolean verifyLogin = userService.verifyLogin(email, password);
		if (verifyLogin != true) {
			modelMap.addAttribute("errorMsg", "Invalid credentials, please try again!");
			return "login/login";
		}
		return "flight/searchFlights";
	}

}
