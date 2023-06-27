package com.grupo22OO22023.services;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo22OO22023.models.EventoModel;

public interface IEventoGenericoService {
	public abstract EventoModel findByIdEvento(int idEvento);
	public abstract List<EventoModel> getAll();
	public abstract List<EventoModel> findByNombreEvento(String nombre);
	public abstract List<EventoModel> findByCreatedAt(LocalDateTime createdAt);
	
	public abstract EventoModel findByIdEventoAndInicializeDependencies(int id);
}
