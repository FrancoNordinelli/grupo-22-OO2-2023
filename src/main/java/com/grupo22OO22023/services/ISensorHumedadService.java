package com.grupo22OO22023.services;

import java.util.List;

import com.grupo22OO22023.models.SensorHumedadModel;

public interface ISensorHumedadService {
	
	public SensorHumedadModel insertOrUpdate(SensorHumedadModel shm);
	
	public boolean remove(int id);

	public List<SensorHumedadModel> getAll();

}
