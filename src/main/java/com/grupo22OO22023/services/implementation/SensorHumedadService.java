package com.grupo22OO22023.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SensorHumedad;
import com.grupo22OO22023.models.SensorHumedadModel;
import com.grupo22OO22023.repositories.ISensorHumedadRepository;
import com.grupo22OO22023.services.ISensorHumedadService;

@Service("SensorHumedad")
public class SensorHumedadService implements ISensorHumedadService {
	
	private ModelMapper mp = new ModelMapper();
	
	@Autowired
	@Qualifier("shRepository")
	private ISensorHumedadRepository shRepository;

	@Override
	public SensorHumedadModel insertOrUpdate(SensorHumedadModel shm) {
		SensorHumedad sensor = shRepository.save(mp.map(shm, SensorHumedad.class));
		return mp.map(sensor, SensorHumedadModel.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			shRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}

}
