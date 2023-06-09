package com.grupo22OO22023.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.repositories.ISmartParkingRepository;
import com.grupo22OO22023.service.ISmartParkingService;

@Service("SmartParking")
public class SmartParkingService implements ISmartParkingService {

	private ModelMapper modelMapper = new ModelMapper();
	@Autowired
	@Qualifier("smartParkingRepository")
	private ISmartParkingRepository smartParkingRepository;
	
	
	
	@Override
	public SmartParkingModel insertOrUpdate(SmartParkingModel smartParkingModel) {
		SmartParking smartParking = smartParkingRepository.save(modelMapper.map(smartParkingModel, SmartParking.class));
		return modelMapper.map(smartParking, SmartParkingModel.class);
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
	public SmartParkingModel searchById(int id) {	
		return smartParkingRepository.findById(id);
	}
	@Override
	public SmartParkingModel searchBynombreDispositivo(String nombreDispositivo) {
		return modelMapper.map(smartParkingRepository.findByNombreDispositivo(nombreDispositivo), 
				SmartParkingModel.class);
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
