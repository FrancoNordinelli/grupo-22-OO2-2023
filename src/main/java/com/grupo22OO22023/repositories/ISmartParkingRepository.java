package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.SmartParking;

@Repository("smartParkingRepository")
public interface ISmartParkingRepository extends JpaRepository<SmartParking, Serializable>{
	
	public abstract SmartParking findById(int id);
	public abstract Optional<SmartParking> findByNombreDispositivo(String nombreDispositivo);
	public abstract Optional<SmartParking> findByCodigoLugarEstacionamiento(String codigoLugarEstacionamiento);
	
	public abstract List<SmartParking> findByOcupado(boolean ocupado);
	public abstract List<SmartParking> findByestadoDispositivo(boolean estadoDispositivo);
	public abstract List<SmartParking> findBycreatedAt(LocalDateTime createdAt);
	public abstract List<SmartParking> findByupdatedAt(LocalDateTime updatedAt);
	
	@Query("SELECT COUNT(sp.id) FROM SmartParking sp")
	public abstract int countCantDispositivos();
}
