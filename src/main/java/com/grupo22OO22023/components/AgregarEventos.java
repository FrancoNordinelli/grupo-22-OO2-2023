package com.grupo22OO22023.components;

import static java.time.temporal.ChronoUnit.HOURS;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.grupo22OO22023.dto.SmartParkingDTO;
import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.models.SPEventoModel;
import com.grupo22OO22023.service.ISPEventoService;
import com.grupo22OO22023.service.ISmartParkingService;

@Component
public class AgregarEventos {
	@Autowired
	@Qualifier("SmartParking")
	private ISmartParkingService smartParkService;
	@Autowired
	@Qualifier("SPEvento")
	private ISPEventoService eventoService;
	private ModelMapper modelMapper = new ModelMapper();

	@Scheduled(fixedDelay=15000)
    public void runJob() throws Exception{
		List<SmartParkingDTO> listaDispo = smartParkService.getAll();
		
		if(listaDispo.size() > 0) {
			LocalDateTime fechaHora = LocalDateTime.now();
			int idDispositivo = (int) Math.random()*listaDispo.size();
			SmartParking dispo = modelMapper.map(listaDispo.get(idDispositivo), SmartParking.class);
			SPEventoModel evento = new SPEventoModel(fechaHora, dispo);
			
			Optional<SmartParkingDTO> aux = Optional.ofNullable(modelMapper.map(
					smartParkService.findById(evento.getDispositivo().getId()),
					SmartParkingDTO.class));
			
			if(aux.isEmpty()) throw new Exception("Error, dispositivo desconocido.");
			
			if(aux.get().isEstadoDispositivo()) {
				evento.setNombreEvento("Lugar estacionamiento " 
						+ evento.getDispositivo().getNombreDispositivo() 
						+ " fue desocupado.");
				
				evento.setHorasOcupado(HOURS.between(
						eventoService.findLastEventoByDispositivo(aux.get().getId()).getCreatedAt(), 
						LocalDateTime.now()));
			} else {
				evento.setNombreEvento("Lugar estacionamiento " 
						+ evento.getDispositivo().getNombreDispositivo() 
						+ " fue ocupado.");
				evento.setHorasOcupado(-1);
			}
			
			aux.get().cambiarEstadoOcupado();
			
			try {
				smartParkService.insertOrUpdate(aux.get());
			} catch(Exception e) {
				System.out.println("Error al actualizar el dispositivo: " + e.toString());
			}
	
			try {
				eventoService.insertOrUpdate(evento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ERROR --->>>" + listaDispo.size());
		}
		System.out.println("Hecho");
	}
}
