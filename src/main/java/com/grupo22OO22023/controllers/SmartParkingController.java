package com.grupo22OO22023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo22OO22023.helpers.Rutas;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.service.ISmartParkingService;

@Controller
@RequestMapping("/sparking")
public class SmartParkingController {
	
	@Autowired
	@Qualifier("SmartParking")
	private ISmartParkingService smartParkService;
	
	@GetMapping("/")
	public ModelAndView administracionSmartParking() {
		ModelAndView mV = new ModelAndView(Rutas.administracionDispositivos3);
		mV.addObject("smartParkingS", smartParkService.getAll());
		mV.addObject("smartParking", new SmartParkingModel());
		return mV;
	}
	//agregar dispositivo
	@PostMapping("/")
	public RedirectView insert(@ModelAttribute("smartParking") 
				SmartParkingModel smartParking) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		smartParkService.insertOrUpdate(smartParking);
		return rV;
	}

	@PostMapping("/modificar")
	public RedirectView cambiarEstadoDispositivob(@ModelAttribute("smartParking") SmartParkingModel smartParking) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		if(smartParkService.searchById(smartParking.getId()) != null) {
			smartParking = smartParkService.searchById(smartParking.getId());
			smartParking.setEstadoDispositivo(!smartParking.isEstadoDispositivo());
			smartParkService.insertOrUpdate(smartParking);
		}
		return rV;
	}
	
	@PostMapping("/eliminar")
	public RedirectView eliminarDispositivo(@ModelAttribute("smartParking") SmartParkingModel smartParking) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		smartParkService.remove(smartParking.getId());
		return rV;
	}
}