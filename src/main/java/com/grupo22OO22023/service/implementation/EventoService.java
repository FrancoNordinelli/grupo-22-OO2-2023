package com.grupo22OO22023.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.Evento;
import com.grupo22OO22023.models.EventoModel;
import com.grupo22OO22023.repositories.IEventoRepository;
import com.grupo22OO22023.service.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService {

	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	private ModelMapper modelMapper = new ModelMapper();
	
	
	
	@Override
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}
	@Override
	public EventoModel insertOrUpdate(EventoModel eventoModel) {
		Evento evento = eventoRepository.save(modelMapper.map(eventoModel, Evento.class));
		return modelMapper.map(evento, EventoModel.class);
	}
	@Override
	public boolean remove(int id) {
		try {
			eventoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<Evento> findByNombreEvento(String nombreEvento){
		return eventoRepository.findByNombreEvento(nombreEvento);
	}
	@Override
	public List<Evento> findByDispositivo(int idDispositivo){
		return eventoRepository.findByDispositivo(idDispositivo);	
	}
	@Override
	public List<Evento> findByCreatedAt(LocalDateTime createdAt){
		return eventoRepository.findByCreatedAt(createdAt);
	}
	@Override
	public EventoModel findByidEvento(int idEvento) {
		return modelMapper.map(eventoRepository.findById(idEvento), EventoModel.class);
	}
	@Override
	public List<EventoModel> findByNombreEventoAndDispositivo(String nombreEvento, int idDispositivo) {
		return eventoRepository.findByNombreEventoAndDispositivo(nombreEvento, idDispositivo);
	}
	public List<EventoModel> findAllEventosWithAttributes(){
		return eventoRepository.findAllEventosWithAttributes();
	}
}
