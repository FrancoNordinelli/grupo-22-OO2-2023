package com.grupo22OO22023.services;

import java.util.List;

import com.grupo22OO22023.models.SHEventoModel;
import com.grupo22OO22023.models.SPEventoModel;
import com.grupo22OO22023.models.SensorHumedadModel;

public interface ISHEventoService {
	
	public SHEventoModel insertOrUpdate(SHEventoModel shEventoModel);
	public boolean remove(int id);
	public SHEventoModel findByidEvento(int id);
	public List<SHEventoModel> buscarPorIdDispositivo(int id);

}
