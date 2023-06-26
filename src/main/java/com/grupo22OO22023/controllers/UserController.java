package com.grupo22OO22023.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grupo22OO22023.helpers.ViewRouteHelper;


@Controller

public class UserController {

	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		
		return ViewRouteHelper.USER_LOGOUT;
	}

	@GetMapping("/loginsuccess")
	public ModelAndView loginCheck() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mV.addObject("username", user.getUsername());
		return mV;
	} 
}
