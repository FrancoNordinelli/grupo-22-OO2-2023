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
import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.models.SPEventoModel;
import com.grupo22OO22023.services.ISPEventoService;
import com.grupo22OO22023.services.ISmartParkingService;

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
			
			Optional<SmartParkingDTO> aux = Optional.ofNullable(listaDispo.get(idDispositivo));
			
			if(aux.isEmpty()) throw new Exception("Error, el dispositivo no existe.");
			if(!aux.get().isEstadoDispositivo()) throw new Exception("Error, ese dispositivo esta desactivado.");
			
			SPEventoModel SPEvento = new SPEventoModel(fechaHora, 
					modelMapper.map(aux.get(), Dispositivo.class)); 
			
			if(aux.get().isOcupado()) {
				SPEvento.setNombreEvento("Lugar estacionamiento " 
						+ SPEvento.getDispositivo().getNombreDispositivo() 
						+ " fue desocupado.");
				
				SPEvento.setHorasOcupado(HOURS.between(
						eventoService.findLastEventoByDispositivo(aux.get().getId()).getCreatedAt(), 
						LocalDateTime.now()));
				aux.get().aumentarVecesOcupado();
			} else {
				SPEvento.setNombreEvento("Lugar estacionamiento " 
						+ SPEvento.getDispositivo().getNombreDispositivo() 
						+ " fue ocupado.");
				SPEvento.setHorasOcupado(0);
			}
			
			aux.get().cambiarEstadoOcupado();
			
			eventoService.insertOrUpdate(modelMapper.map(SPEvento, SPEventoModel.class));
			smartParkService.insertOrUpdate(modelMapper.map(aux.get(), SmartParkingDTO.class));
			
		}
	}
}
