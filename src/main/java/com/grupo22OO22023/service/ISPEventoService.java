package com.grupo22OO22023.service;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo22OO22023.models.SPEventoModel;

public interface ISPEventoService {
	public SPEventoModel insertOrUpdate(SPEventoModel sParkingEventoModel);
	public boolean remove(int id);

	
	public SPEventoModel findByidEvento(int idEvento);
	
	public List<SPEventoModel> getAll();
	
	public List<SPEventoModel> findByNombreEvento(String nombreEvento);
	public List<SPEventoModel> findByCreatedAt(LocalDateTime createdAt);
	public List<SPEventoModel> findByNombreEventoAndDispositivo(String nombreEvento, int id);
	public List<SPEventoModel> findAllEventosWithAttributes();
	public List<SPEventoModel> findByDispositivo(int idDispositivo);

	public SPEventoModel findLastEventoByDispositivo(int id);
}
