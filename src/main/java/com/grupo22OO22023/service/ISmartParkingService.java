package com.grupo22OO22023.service;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.models.SmartParkingModel;

public interface ISmartParkingService {
	
	public SmartParkingModel insertOrUpdate(SmartParkingModel smartParkingModel);
	public boolean remove(int id);
	
	public SmartParkingModel searchById(int id);
	public SmartParkingModel searchBynombreDispositivo(String nombreDispositivo);
	
	public List<SmartParking> getAll();
	public List<SmartParking> searchByOcupado(boolean ocupado);
	public List<SmartParking> searchByestadoDispositivo(boolean estadoDispositivo);
	public List<SmartParking> serchBycreatedAt(LocalDateTime createdAt);
	public List<SmartParking> serchByupdatedAt(LocalDateTime updatedAt);
}
