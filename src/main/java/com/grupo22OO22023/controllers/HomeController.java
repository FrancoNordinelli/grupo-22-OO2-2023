package com.grupo22OO22023.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupo22OO22023.helpers.ViewRouteHelper;



//TODO:PAGINA DE LOGUIN: LOGUIN DISTINTO SEGUN SEA ADMIN O AUDITOR
@Controller
@RequestMapping("/")
public class HomeController {
	
	

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		
		return modelAndView;
	}
}
