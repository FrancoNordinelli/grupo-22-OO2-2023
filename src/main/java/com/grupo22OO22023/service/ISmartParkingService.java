package com.grupo22OO22023.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.grupo22OO22023.entities.SmartParking;

public interface ISmartParkingService {
	
	public SmartParking insertOrUpdate(SmartParking smartParking);
	public boolean remove(int id);
	
	public Optional<SmartParking> findById(int id);
	public Optional<SmartParking> findBynombreDispositivo(String nombreDispositivo);
	public Optional<SmartParking> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento);
	
	public List<SmartParking> getAll();
	public List<SmartParking> searchByOcupado(boolean ocupado);
	public List<SmartParking> searchByestadoDispositivo(boolean estadoDispositivo);
	public List<SmartParking> serchBycreatedAt(LocalDateTime createdAt);
	public List<SmartParking> serchByupdatedAt(LocalDateTime updatedAt);
}

