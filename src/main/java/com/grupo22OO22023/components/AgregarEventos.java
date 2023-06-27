package com.grupo22OO22023.components;

import static java.time.temporal.ChronoUnit.HOURS;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.models.SPEventoModel;
import com.grupo22OO22023.models.SmartParkingModel;
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
		int cantSParking = smartParkService.countCantDispositivos();
		int cantEvento = eventoService.cantidadEventos();
		
		if(cantSParking > 0) {
			LocalDateTime fechaHora = LocalDateTime.now();
			int idDispositivo = (int) Math.random()*cantSParking +1;
			
			 
			SmartParkingModel aux = smartParkService.findById(idDispositivo).get();
			SPEventoModel sPEvento = new SPEventoModel(fechaHora, modelMapper.map(aux, Dispositivo.class));
			
			if(aux.isOcupado()) {
				
				aux.setOcupado(false);
				sPEvento.setNombreEvento("Lugar estacionamiento " + sPEvento.getDispositivo().getNombreDispositivo() + " fue desocupado.");
				
				if(cantEvento>0) {
					sPEvento.setHorasOcupado(HOURS.between(eventoService.findLastEventoByDispositivo(aux.getId()).getCreatedAt(), fechaHora));
				}else {
					sPEvento.setHorasOcupado(0);
				}
				
			} else {
				
				aux.setOcupado(true);
				sPEvento.setNombreEvento("Lugar estacionamiento " + sPEvento.getDispositivo().getNombreDispositivo() + " fue ocupado.");
				sPEvento.setHorasOcupado(0);
				
			}
			
			eventoService.insertOrUpdate(sPEvento);
			smartParkService.insertOrUpdate(aux);
			System.out.println("Existo");
		}
	}
}
