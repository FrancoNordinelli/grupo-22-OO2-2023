package com.grupo22OO22023.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.repositories.ISmartParkingRepository;
import com.grupo22OO22023.service.ISmartParkingService;

@Service("SmartParking")
public class SmartParkingService implements ISmartParkingService {

	@Autowired
	@Qualifier("smartParkingRepository")
	private ISmartParkingRepository smartParkingRepository;
	
	@Override
	public SmartParking insertOrUpdate(SmartParking smartParking) {
		return smartParkingRepository.save(smartParking);
	}
	@Override
	public boolean remove(int id) {
		try {
			smartParkingRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public Optional<SmartParking> findById(int id) {
		return Optional.ofNullable(smartParkingRepository.findById(id));
	}
	@Override
	public Optional<SmartParking> findBynombreDispositivo(String nombreDispositivo) {
		return smartParkingRepository.findByNombreDispositivo(nombreDispositivo);
	}
	@Override
	public Optional<SmartParking> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento) {	
		return smartParkingRepository.findByCodigoLugarEstacionamiento(codigoLugarEstacionamiento);
	}

	@Override
	public List<SmartParking> getAll() {
		return smartParkingRepository.findAll();
	}
	@Override
	public List<SmartParking> searchByOcupado(boolean ocupado) {
		return smartParkingRepository.findByOcupado(ocupado);
	}
	@Override
	public List<SmartParking> searchByestadoDispositivo(boolean estadoDispositivo) {
		return smartParkingRepository.findByestadoDispositivo(estadoDispositivo);
	}
	@Override
	public List<SmartParking> serchBycreatedAt(LocalDateTime createdAt) {
		return smartParkingRepository.findBycreatedAt(createdAt);
	}
	@Override
	public List<SmartParking> serchByupdatedAt(LocalDateTime updatedAt) {
		return smartParkingRepository.findByupdatedAt(updatedAt);
	}
}
