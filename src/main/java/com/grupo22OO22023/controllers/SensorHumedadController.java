package com.grupo22OO22023.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo22OO22023.helpers.ViewRouteHelper;
import com.grupo22OO22023.models.SensorHumedadModel;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.services.ISHEventoService;
import com.grupo22OO22023.services.ISensorHumedadService;

@Controller
@RequestMapping("/sensorHDispositivo")
public class SensorHumedadController {
	
	@Autowired
	@Qualifier("SensorHumedad")
	private ISensorHumedadService shService;
	@Autowired
	@Qualifier("SHEvento")
	private ISHEventoService shEvento;
	private ModelMapper mp = new ModelMapper();
	
	
	@GetMapping("/")
	public ModelAndView administracionSensoresHumedad() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.SenshorH);
		mV.addObject("shDispositivo", new SensorHumedadModel());
		return mV;
	}
	
	
	@PostMapping("/")
	public RedirectView crearSensor(@ModelAttribute SensorHumedadModel sh) {
		shService.insertOrUpdate(sh);
		return new RedirectView(ViewRouteHelper.INDICESHUMEDAD);
	}
	
//	@PostMapping("/")
//	public ModelAndView crearSensorH(@ModelAttribute("shDispositivo") SensorHumedadModel sh) {
//		ModelAndView mV = new ModelAndView();
//		mV.setViewName(ViewRouteHelper.SenshorH);
//		mV.addObject("shDispositivo", sh);
//		return mV;
//	}

}
