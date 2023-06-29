package com.grupo22OO22023.services;

import java.util.List;

import com.grupo22OO22023.models.SHEventoModel;


public interface ISHEventoService {
	
	public SHEventoModel insertOrUpdate(SHEventoModel shEventoModel);
	public boolean remove(int id);
	public SHEventoModel findByidEvento(int id);
	public List<SHEventoModel> buscarPorIdDispositivo(int id);

}
