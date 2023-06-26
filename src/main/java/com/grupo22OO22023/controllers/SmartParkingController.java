package com.grupo22OO22023.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import com.grupo22OO22023.entities.SmartParking;

import com.grupo22OO22023.helpers.ViewRouteHelper;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.repositories.ISPEventoRepository;
import com.grupo22OO22023.services.ISPEventoService;
import com.grupo22OO22023.services.ISmartParkingService;

@Controller
@RequestMapping("/sparking")
public class SmartParkingController {
	@Autowired
	@Qualifier("SmartParking")
	private ISmartParkingService smartParkService;
	@Autowired
	@Qualifier("SPEvento")
	private ISPEventoService sPEventoService;
	private ModelMapper modelMapper = new ModelMapper();

	
	@GetMapping("/")
	public ModelAndView administracionSmartParking() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.administracionDispositivos);
		mV.addObject("sparkingDispositivo", new SmartParkingModel());
		mV.addObject("dispositivos", getAllDispositivos());
		return mV;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eventos/{id}")
	public ModelAndView eventosDeDispositivo(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.visualizarEventosDeDispositivo);
		mV.addObject("dispositivo", getDispostivo(id));
		mV.addObject("eventos", sPEventoService.findByDispositivo(id));
		return mV;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/")
	public RedirectView crearSmartParking(@ModelAttribute SmartParkingModel sp) {
		smartParkService.insertOrUpdate(sp);
		return new RedirectView(ViewRouteHelper.indiceDispositivos);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/")
	public RedirectView modificarSmartParking(@ModelAttribute SmartParkingModel sp) {
		smartParkService.insertOrUpdate(sp);
		return new RedirectView(ViewRouteHelper.indiceDispositivos);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/desactivar")	
	public RedirectView eliminarSmartParking(@ModelAttribute int id) {
		Optional<SmartParkingModel> aux = smartParkService.findById(id);
		
		//validaciones?
		
		aux.get().setEstadoDispositivo(false);
		smartParkService.insertOrUpdate(aux.get());
		return new RedirectView(ViewRouteHelper.indiceDispositivos);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/activar")
	public RedirectView activarSmartParking(@ModelAttribute int id) {
		Optional<SmartParkingModel> aux = smartParkService.findById(id); 
		
		//comprobaciones?
		
		aux.get().setEstadoDispositivo(true);
		smartParkService.insertOrUpdate(aux.get());
		return new RedirectView(ViewRouteHelper.indiceDispositivos);
	}
	

	@GetMapping("/get/{id}")
	public SmartParkingModel getDispostivo(@PathVariable("id") int id) {

		Optional<SmartParkingModel> aux = smartParkService.findById(id); 
		return aux.get();
	}
	@GetMapping("/getAll")
	public List<SmartParkingModel> getAllDispositivos() {
		
		//muy posiblemente haya que aplicar el filtro aca
		
		List<SmartParkingModel> aux = smartParkService.getAll().stream()
				.map(SmartParking -> modelMapper.map(SmartParking, SmartParkingModel.class))
				.collect(Collectors.toList());
		
		return aux;
	}
}