package com.grupo22OO22023.service;

import java.util.List;

import com.grupo22OO22023.entities.Evento;
import com.grupo22OO22023.models.EventoModel;

public interface IEventoService {
	public List<Evento> getAll();
	
	public EventoModel insertOrUpdate(EventoModel eventoModel);
	
	public boolean remove(int id);
}
