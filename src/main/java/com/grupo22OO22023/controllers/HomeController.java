package com.grupo22OO22023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo22OO22023.helpers.ViewRouteHelper;



//TODO:PAGINA DE LOGUIN: LOGUIN DISTINTO SEGUN SEA ADMIN O AUDITOR
@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/index")
	public String index() {
		return ViewRouteHelper.INDEX;
	}

}
