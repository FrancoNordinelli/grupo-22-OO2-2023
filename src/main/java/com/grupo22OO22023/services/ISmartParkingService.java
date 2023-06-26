package com.grupo22OO22023.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.grupo22OO22023.models.SmartParkingModel;


public interface ISmartParkingService {
	public SmartParkingModel insertOrUpdate(SmartParkingModel smartParking);
	public boolean remove(int id);
	
	public Optional<SmartParkingModel> findById(int id);
	public Optional<SmartParkingModel> findBynombreDispositivo(String nombreDispositivo);
	public Optional<SmartParkingModel> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento);
	
	public List<SmartParkingModel> getAll();
	public List<SmartParkingModel> searchByOcupado(boolean ocupado);
	public List<SmartParkingModel> searchByestadoDispositivo(boolean estadoDispositivo);
	public List<SmartParkingModel> serchBycreatedAt(LocalDateTime createdAt);
	public List<SmartParkingModel> serchByupdatedAt(LocalDateTime updatedAt);
	
	public int countCantDispositivos();
}

