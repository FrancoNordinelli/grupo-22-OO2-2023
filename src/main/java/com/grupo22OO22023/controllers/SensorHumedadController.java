package com.grupo22OO22023.controllers;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo22OO22023.helpers.ViewRouteHelper;
import com.grupo22OO22023.models.SensorHumedadModel;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.services.ISHEventoService;
import com.grupo22OO22023.services.ISensorHumedadService;

import jakarta.validation.constraints.AssertFalse.List;

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
		mV.addObject("sensores", getAll());
		return mV;
	}
	
	
	private java.util.List<SensorHumedadModel> getAll() {
		java.util.List<SensorHumedadModel>sensores = shService.getAll().stream()
				.map(Sensores -> mp.map(Sensores,SensorHumedadModel.class)).collect(Collectors.toList());
		return sensores;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/")
	public RedirectView crearSensor(@ModelAttribute SensorHumedadModel sh) {
		shService.insertOrUpdate(sh);
		return new RedirectView(ViewRouteHelper.INDICESHUMEDAD);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/modificar/{id}")
	public RedirectView modificarSensorHumedad(@PathVariable("id") int id, @ModelAttribute SensorHumedadModel sh) {
		sh.setId(id);
		shService.insertOrUpdate(sh);
		return new RedirectView(ViewRouteHelper.INDICESHUMEDAD);
	}


	@GetMapping("/eventos/{id}")
	public ModelAndView eventosDeSensor(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.eventosSensor);
		mV.addObject("sensores", getSensor(id));
		mV.addObject("eventos", shEvento.buscarPorIdDispositivo(id));
		mV.addObject("sensorCambio", new SensorHumedadModel());
		return mV;
	}
	
	
	
	public Optional<SensorHumedadModel> getSensor(int id) {
		return  shService.findById(id);
	}
	

}
