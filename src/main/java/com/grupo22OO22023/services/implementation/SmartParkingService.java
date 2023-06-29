package com.grupo22OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.models.SmartParkingModel;
import com.grupo22OO22023.repositories.ISmartParkingRepository;
import com.grupo22OO22023.services.ISmartParkingService;

@Service("SmartParking")
public class SmartParkingService implements ISmartParkingService {
	private ModelMapper modelMapper = new ModelMapper(); 
	@Autowired
	@Qualifier("smartParkingRepository")
	private ISmartParkingRepository smartParkingRepository;
	
	@Override
	public SmartParkingModel insertOrUpdate(SmartParkingModel smartParking) {
		SmartParking sp = smartParkingRepository.save(modelMapper.map(
				smartParking, SmartParking.class));
		return modelMapper.map(sp, SmartParkingModel.class);
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
	public Optional<SmartParkingModel> findById(int id) {
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findById(id),
				SmartParkingModel.class));
	}
	@Override
	public Optional<SmartParkingModel> findBynombreDispositivo(String nombreDispositivo) {
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findByNombreDispositivo(nombreDispositivo),
				SmartParkingModel.class));
	}
	@Override
	public Optional<SmartParkingModel> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento) {	
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findByCodigoLugarEstacionamiento(codigoLugarEstacionamiento),
				SmartParkingModel.class));
	}

	@Override
	public List<SmartParkingModel> getAll() {
		return smartParkingRepository.findAll().stream()
				.map(sp -> modelMapper.map(sp, SmartParkingModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingModel> searchByOcupado(boolean ocupado) {
		return smartParkingRepository.findByOcupado(ocupado).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingModel> searchByestadoDispositivo(boolean estadoDispositivo) {
		return smartParkingRepository.findByestadoDispositivo(estadoDispositivo).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingModel> serchBycreatedAt(LocalDateTime createdAt) {
		return smartParkingRepository.findBycreatedAt(createdAt).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingModel.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingModel> serchByupdatedAt(LocalDateTime updatedAt) {
		return smartParkingRepository.findByupdatedAt(updatedAt).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingModel.class))
				.collect(Collectors.toList());
	}

	public List<Integer> findAllIdDispositivos(){
		return  smartParkingRepository.findAllIdDispositivos();
	}
}
