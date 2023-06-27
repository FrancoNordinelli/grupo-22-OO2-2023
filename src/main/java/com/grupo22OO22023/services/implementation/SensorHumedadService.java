package com.grupo22OO22023.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SensorHumedad;
import com.grupo22OO22023.models.SensorHumedadModel;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.repositories.ISensorHumedadRepository;
import com.grupo22OO22023.services.ISensorHumedadService;

@Service("SensorHumedad")
public class SensorHumedadService implements ISensorHumedadService {
	
	private ModelMapper mp = new ModelMapper();
	
	@Autowired
	@Qualifier("sensorHumedadRepository")
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

	@Override
	public List<SensorHumedadModel> getAll() {
		return shRepository.findAll().stream().map(sensores -> mp.map(sensores, SensorHumedadModel.class)).collect(Collectors.toList());
		
	}

	@Override
	public Optional<SensorHumedadModel> findById(int id) {
		return Optional.ofNullable(mp.map(
				shRepository.findById(id),
				SensorHumedadModel.class));
	}

}
