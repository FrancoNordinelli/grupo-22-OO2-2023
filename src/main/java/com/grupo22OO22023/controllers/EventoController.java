package com.grupo22OO22023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupo22OO22023.helpers.ViewRouteHelper;
import com.grupo22OO22023.services.implementation.EventoGenericoService;

@Controller
@RequestMapping("/evento")
public class EventoController {
	@Autowired
	@Qualifier("EventoGenericoService")
	private EventoGenericoService eventoService;
	
	@GetMapping("/")
	public ModelAndView eventos() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.visualizarEventos);
		mV.addObject("eventos", eventoService.getAll());
		return mV;
	}
	@GetMapping("/{id}")
	public ModelAndView eventoParticular(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.visualizarEventoParticular);
		mV.addObject("evento", eventoService.findByIdEventoAndInicializeDependencies(id));
		return mV;
	}
}
