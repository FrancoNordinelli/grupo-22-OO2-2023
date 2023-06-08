package com.grupo22OO22023.service.implementation;

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
}
