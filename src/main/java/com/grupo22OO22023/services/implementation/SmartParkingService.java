package com.grupo22OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo22OO22023.dto.SmartParkingDTO;
import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.repositories.ISmartParkingRepository;
import com.grupo22OO22023.services.ISmartParkingService;

@Service("SmartParking")
public class SmartParkingService implements ISmartParkingService {
	private ModelMapper modelMapper = new ModelMapper(); 
	@Autowired
	@Qualifier("smartParkingRepository")
	private ISmartParkingRepository smartParkingRepository;
	
	@Override
	public SmartParkingDTO insertOrUpdate(SmartParkingDTO smartParking) {
		SmartParking sp = smartParkingRepository.save(modelMapper.map(
				smartParking, SmartParking.class));
		return modelMapper.map(sp, SmartParkingDTO.class);
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
	public Optional<SmartParkingDTO> findById(int id) {
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findById(id),
				SmartParkingDTO.class));
	}
	@Override
	public Optional<SmartParkingDTO> findBynombreDispositivo(String nombreDispositivo) {
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findByNombreDispositivo(nombreDispositivo),
				SmartParkingDTO.class));
	}
	@Override
	public Optional<SmartParkingDTO> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento) {	
		return Optional.ofNullable(modelMapper.map(
				smartParkingRepository.findByCodigoLugarEstacionamiento(codigoLugarEstacionamiento),
				SmartParkingDTO.class));
	}

	@Override
	public List<SmartParkingDTO> getAll() {
		return smartParkingRepository.findAll().stream()
				.map(sp -> modelMapper.map(sp, SmartParkingDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingDTO> searchByOcupado(boolean ocupado) {
		return smartParkingRepository.findByOcupado(ocupado).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingDTO> searchByestadoDispositivo(boolean estadoDispositivo) {
		return smartParkingRepository.findByestadoDispositivo(estadoDispositivo).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingDTO> serchBycreatedAt(LocalDateTime createdAt) {
		return smartParkingRepository.findBycreatedAt(createdAt).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public List<SmartParkingDTO> serchByupdatedAt(LocalDateTime updatedAt) {
		return smartParkingRepository.findByupdatedAt(updatedAt).stream()
				.map(sp -> modelMapper.map(sp, SmartParkingDTO.class))
				.collect(Collectors.toList());
	}

	public int countCantDispositivos() {
		return smartParkingRepository.countCantDispositivos();
	}	
}
