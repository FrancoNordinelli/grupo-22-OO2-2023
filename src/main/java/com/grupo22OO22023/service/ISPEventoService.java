package com.grupo22OO22023.service;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo22OO22023.models.SPEventoModel;

public interface ISPEventoService {
	public SPEventoModel insertOrUpdate(SPEventoModel sParkingEventoModel);
	public boolean remove(int id);

	public abstract SPEventoModel findByidEvento(int idEvento);
	
	public List<SPEventoModel> getAll();
	
	public abstract List<SPEventoModel> findByNombreEvento(String nombreEvento);
	public abstract List<SPEventoModel> findByCreatedAt(LocalDateTime createdAt);

	public abstract List<SPEventoModel> findAllEventosWithAttributes();
	public abstract List<SPEventoModel> findByDispositivo(int idDispositivo);
	public abstract List<SPEventoModel> findByNombreEventoAndDispositivo(String nombreEvento, int idDispositivo);
}
