package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.SmartParking;
import com.grupo22OO22023.models.SmartParkingModel;

@Repository("smartParkingRepository")
public interface ISmartParkingRepository extends JpaRepository<SmartParking, Serializable>{
	
	public abstract SmartParking findByNombreDispositivo(String nombreDispositivo);
	public abstract SmartParking findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento);
	public abstract SmartParkingModel findById(int id);

	
	public abstract List<SmartParking> findByupdatedAt(LocalDateTime updatedAt);
	public abstract List<SmartParking> findBycreatedAt(LocalDateTime createdAt);
	public abstract List<SmartParking> findByestadoDispositivo(boolean estadoDispositivo);
	public abstract List<SmartParking> findByOcupado(boolean ocupado);
}
