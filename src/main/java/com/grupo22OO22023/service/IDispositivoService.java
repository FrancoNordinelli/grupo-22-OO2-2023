package com.grupo22OO22023.service;

import java.util.List;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.models.DispositivoModel;

public interface IDispositivoService {
	
	public List<Dispositivo> getAll();
	
	public DispositivoModel insertOrUpdate(DispositivoModel dispositivoModel);
	
	public boolean remove(int id);
	
	public DispositivoModel searchById(int id);
}
