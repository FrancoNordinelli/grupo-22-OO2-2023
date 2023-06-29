package com.grupo22OO22023.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grupo22OO22023.components.AgregarEventosSensor;
import com.grupo22OO22023.helpers.ViewRouteHelper;
import com.grupo22OO22023.repositories.ISensorHumedadRepository;
import com.grupo22OO22023.services.ISHEventoService;
import com.grupo22OO22023.services.ISensorHumedadService;


@Controller

public class UserController {
	
	
	private ISensorHumedadService shService;
	private ISHEventoService shI;

    public UserController(ISensorHumedadService shService, ISHEventoService shI) {
        this.shService = shService;
        this.shI = shI;
    }

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
		
        AgregarEventosSensor agregarEventosSensor = new AgregarEventosSensor(shService, shI);
        
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        
        executorService.execute(agregarEventosSensor);

		
		
		mV.addObject("username", user.getUsername());
		return mV;
	} 
}
