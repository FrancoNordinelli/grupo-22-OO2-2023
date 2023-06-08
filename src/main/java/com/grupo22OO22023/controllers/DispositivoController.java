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
import com.grupo22OO22023.models.DispositivoModel;
import com.grupo22OO22023.service.IDispositivoService;

@RequestMapping("/dispositivos")
@Controller
public class DispositivoController {

	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@GetMapping("/")
	public ModelAndView administracionDispositivos() {
		ModelAndView mV = new ModelAndView(Rutas.administracionDispositivos3);
		mV.addObject("dispositivos", dispositivoService.getAll());
		mV.addObject("dispositivo", new DispositivoModel());
		//mV.addObject("dispositivoAModificar", new DispositivoModel());
		return mV;
	}
	//agregar dispositivo
	@PostMapping("/")
	public RedirectView insert(@ModelAttribute("dispositivo") 
				DispositivoModel dispositivoModel) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		dispositivoService.insertOrUpdate(dispositivoModel);
		return rV;
	}

	@PostMapping("/modificar")
	public RedirectView cambiarEstadoDispositivob(@ModelAttribute("dispositivo") DispositivoModel dispositivo) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		dispositivo = dispositivoService.searchById(dispositivo.getId());
		dispositivo.setEstadoDispositivo(!dispositivo.isEstadoDispositivo());
		dispositivoService.insertOrUpdate(dispositivo);
		return rV;
	}
	
	@PostMapping("/eliminar")
	public RedirectView eliminarDispositivo(@ModelAttribute("dispositivo") DispositivoModel dispositivo) {
		RedirectView rV = new RedirectView(Rutas.indiceDispositivos);
		dispositivoService.remove(dispositivo.getId());
		return rV;
	}
}
