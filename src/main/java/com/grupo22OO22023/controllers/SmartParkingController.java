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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.grupo22OO22023.dto.SmartParkingDTO;
import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.helpers.Rutas;
import com.grupo22OO22023.service.ISmartParkingService;

@RestController
@RequestMapping("/sparking")
public class SmartParkingController {
	@Autowired
	@Qualifier("SmartParking")
	private ISmartParkingService smartParkService;
	private ModelMapper modelMapper = new ModelMapper();

	
	@GetMapping("/")
	public ModelAndView administracionSmartParking() {
		ModelAndView mV = new ModelAndView(Rutas.administracionDispositivos);
		return mV;
	}
	@GetMapping("/eventos/{id}")
	public ModelAndView eventosDeDispositivo(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(Rutas.visualizarEventosDeDispositivo);		
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/")
	public ResponseEntity crearSmartParking(@RequestBody SmartParkingDTO sp) {
		if(sp == null) return new ResponseEntity<String>("El objeto no puede ser nulo.", 
				HttpStatus.BAD_REQUEST);
		
		Optional<SmartParking> aux = Optional.ofNullable(modelMapper.map(
				smartParkService.findBynombreDispositivo(sp.getNombreDispositivo()), 
				SmartParking.class)) ; 
		
		if(aux.isPresent()) return new ResponseEntity<String>("El objeto esta repetido.", 
				HttpStatus.BAD_REQUEST);
		try {
			smartParkService.insertOrUpdate(sp);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity(sp, HttpStatus.CREATED);		
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("/")
	public ResponseEntity modificarSmartParking(@RequestBody SmartParkingDTO sp) {
		Optional<SmartParking> aux = Optional.ofNullable(modelMapper.map(
				smartParkService.findById(sp.getId()), 
				SmartParking.class));
		
		if(aux.isEmpty()) return new ResponseEntity<String>("No existe ese dispositivo en la base de datos.", 
				HttpStatus.BAD_REQUEST);
		
		try {
			smartParkService.insertOrUpdate(sp);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SmartParkingDTO>(sp, HttpStatus.OK);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("/desactivar")
	public ResponseEntity eliminarSmartParking(@RequestBody int id) {
		if(id <= 0) return new ResponseEntity<String>(
				"Error, ese ID es invalido",
				HttpStatus.BAD_REQUEST);
		
		Optional<SmartParkingDTO> aux = smartParkService.findById(id); 
		
		if(aux.isEmpty()) return new ResponseEntity<String>(
				"Esa entrada no existe en la Base de datos.", 
				HttpStatus.NOT_FOUND);
		
		aux.get().setEstadoDispositivo(false);
		smartParkService.insertOrUpdate(aux.get());
		return new ResponseEntity<String>("Entrada Desactivada.", HttpStatus.OK);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("/activar")
	public ResponseEntity activarSmartParking(@RequestBody int id) {
		if(id <= 0) return new ResponseEntity<String>(
				"Error, ese ID es invalido",
				HttpStatus.BAD_REQUEST);
		
		Optional<SmartParkingDTO> aux = smartParkService.findById(id); 
		
		if(aux.isEmpty()) return new ResponseEntity<String>(
				"Esa entrada no existe en la Base de datos.", 
				HttpStatus.NOT_FOUND);
		
		aux.get().setEstadoDispositivo(true);
		smartParkService.insertOrUpdate(aux.get());
		return new ResponseEntity<String>("Entrada Reactivada.", HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/get/{id}")
	public ResponseEntity getDispostivo(@PathVariable("id") int id) {
		if(id < 0) return new ResponseEntity<String>(
				"Error: id invalido.",
				HttpStatus.BAD_REQUEST
				);
		
		Optional<SmartParking> aux = Optional.ofNullable(modelMapper.map(
				smartParkService.findById(id), 
				SmartParking.class)); 
		
		if(aux.isEmpty()) return new ResponseEntity<String>(
				"Error: no existe en la base de datos.",
				HttpStatus.NOT_FOUND
				);
		
		return new ResponseEntity<SmartParkingDTO>(
				modelMapper.map(aux.get(), SmartParkingDTO.class),
				HttpStatus.OK
				);
	}
	@SuppressWarnings("rawtypes")
	@GetMapping("/getAll")
	public ResponseEntity getAllDispositivos() {
		
		//muy posiblemente haya que aplicar el filtro aca
		
		List<SmartParkingDTO> aux = smartParkService.getAll().stream()
				.map(SmartParking -> modelMapper.map(SmartParking, SmartParkingDTO.class))
				.collect(Collectors.toList());
		
		
		return new ResponseEntity<List<SmartParkingDTO>>(aux, HttpStatus.OK);
	}
}