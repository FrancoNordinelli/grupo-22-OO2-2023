package com.grupo22OO22023.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.grupo22OO22023.dto.SmartParkingDTO;

public interface ISmartParkingService {
	public SmartParkingDTO insertOrUpdate(SmartParkingDTO smartParking);
	public boolean remove(int id);
	
	public Optional<SmartParkingDTO> findById(int id);
	public Optional<SmartParkingDTO> findBynombreDispositivo(String nombreDispositivo);
	public Optional<SmartParkingDTO> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento);
	
	public List<SmartParkingDTO> getAll();
	public List<SmartParkingDTO> searchByOcupado(boolean ocupado);
	public List<SmartParkingDTO> searchByestadoDispositivo(boolean estadoDispositivo);
	public List<SmartParkingDTO> serchBycreatedAt(LocalDateTime createdAt);
	public List<SmartParkingDTO> serchByupdatedAt(LocalDateTime updatedAt);
	
	public int countCantDispositivos();
}

