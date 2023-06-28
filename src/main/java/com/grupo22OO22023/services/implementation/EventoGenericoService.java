package com.grupo22OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.models.EventoModel;
import com.grupo22OO22023.repositories.IEventoGenericoRepository;
import com.grupo22OO22023.services.IEventoGenericoService;

@Service("EventoGenericoService")
public class EventoGenericoService implements IEventoGenericoService{
	@Autowired
	@Qualifier("EventoGenericoRepository")
	private IEventoGenericoRepository eventoGenericoRepository; 
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<EventoModel> getAll() {
		return eventoGenericoRepository.findAll().stream()
				.map(evento -> modelMapper.map(evento, EventoModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public EventoModel findByIdEvento(int idEvento) {
		return modelMapper.map(eventoGenericoRepository.findById(idEvento), EventoModel.class);
	}
	@Override
	public List<EventoModel> findByNombreEvento(String nombre) {
		return eventoGenericoRepository.findByNombreEvento(nombre).stream()
				.map(evento -> modelMapper.map(evento, EventoModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<EventoModel> findByCreatedAt(LocalDateTime createdAt) {
		return eventoGenericoRepository.findByCreatedAt(createdAt).stream()
				.map(evento -> modelMapper.map(evento, EventoModel.class))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public EventoModel findByIdEventoAndInicializeDependencies(int id) {
		return modelMapper.map(eventoGenericoRepository.findByIdEventoAndInicializeDependencies(id),
				EventoModel.class);
	}
	@Override
	public List<EventoModel> findAllAndInicializeDependencies() {
		return eventoGenericoRepository.findAllAndInicializeDependencies()
				.stream()
				.map(evento -> modelMapper.map(evento, EventoModel.class))
				.collect(Collectors.toList());
	}
}
