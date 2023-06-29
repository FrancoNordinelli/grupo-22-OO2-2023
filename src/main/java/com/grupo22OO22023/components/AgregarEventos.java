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
		List<Integer> cantSParking = smartParkService.findAllIdDispositivos();
		int cantEvento = eventoService.cantidadEventos();
		
		if(!cantSParking.isEmpty()) {
			LocalDateTime fechaHora = LocalDateTime.now();
			int idDispositivo = (int) (Math.random()*cantSParking.size()) +1;
			
			Optional<SmartParkingModel> aux = smartParkService.findById(cantSParking.get(idDispositivo-1));
			System.out.println(aux.isPresent());
			if(aux.isPresent() && aux.get().getCodigoLugarEstacionamiento()!=null) {
				SPEventoModel sPEvento = new SPEventoModel(fechaHora, modelMapper.map(aux.get(), Dispositivo.class));
				if(aux.get().isOcupado()) {
					aux.get().setOcupado(false);
					aux.get().aumentarContadorOcupado();
					sPEvento.setNombreEvento("Lugar estacionamiento " + 
											sPEvento.getDispositivo().getNombreDispositivo() + 
											" fue desocupado.");
					
					if(cantEvento>0) {
						sPEvento.setHorasOcupado(HOURS.between(eventoService.findLastEventoByDispositivo(aux.get().getId()).getCreatedAt(), fechaHora));
					}else {
						sPEvento.setHorasOcupado(0);
					}
				} else {
					aux.get().setOcupado(true);
					sPEvento.setNombreEvento("Lugar estacionamiento " + sPEvento.getDispositivo().getNombreDispositivo() + " fue ocupado.");
					sPEvento.setHorasOcupado(0);	
				}
				eventoService.insertOrUpdate(sPEvento);
				smartParkService.insertOrUpdate(aux.get());
				System.out.println("DEBUG eliminame  ----->>> Existo");
			}else {
				System.out.println("DEBUG eliminame  ----->>> no existo");
			}
		}
	}
}
