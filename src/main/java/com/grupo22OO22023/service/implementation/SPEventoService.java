package com.grupo22OO22023.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SPEvento;
import com.grupo22OO22023.models.SPEventoModel;
import com.grupo22OO22023.repositories.ISPEventoRepository;
import com.grupo22OO22023.service.ISPEventoService;

@Service("SPEvento")
public class SPEventoService implements ISPEventoService {
	@Autowired
	@Qualifier("spEventoRepository")
	private ISPEventoRepository spEventoRepository;
	private ModelMapper modelMapper = new ModelMapper();
	
	
	@Override
	public SPEventoModel insertOrUpdate(SPEventoModel eventoModel) {
		SPEvento evento = spEventoRepository.save(modelMapper.map(eventoModel, SPEvento.class));
		return modelMapper.map(evento, SPEventoModel.class);
	}
	@Override
	public boolean remove(int id) {
		try {
			spEventoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public SPEventoModel findByidEvento(int SPEvento) {
		return modelMapper.map(spEventoRepository.findById(SPEvento), SPEventoModel.class);
	}
	
	@Override
	public List<SPEventoModel> getAll() {	
		return spEventoRepository.findAll().stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<SPEventoModel> findByNombreEvento(String nombreEvento){
		return spEventoRepository.findByNombreEvento(nombreEvento).stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SPEventoModel> findByCreatedAt(LocalDateTime createdAt){
		return spEventoRepository.findByCreatedAt(createdAt).stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());
	}
	public List<SPEventoModel> findByNombreEventoAndDispositivo(String nombreEvento, int id) {
		return spEventoRepository.findByNombreEventoAndDispositivo(nombreEvento, id)
				.stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());
	}
	public List<SPEventoModel> findAllEventosWithAttributes(){
		return spEventoRepository.findAllEventosWithAttributes().stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SPEventoModel> findByDispositivo(int idDispositivo){
		return spEventoRepository.findByDispositivo(idDispositivo).stream()
				.map(spEvento -> modelMapper.map(spEvento, SPEventoModel.class))
				.collect(Collectors.toList());	
	}

	public SPEventoModel findLastEventoByDispositivo(int id) {
		return modelMapper.map(spEventoRepository.
				findByIdDispositivoOrderedByIdDispositivoDESC(id).get(0), 
				SPEventoModel.class);
	}
}
