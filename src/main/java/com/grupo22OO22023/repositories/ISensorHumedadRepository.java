package com.grupo22OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.SensorHumedad;


@Repository("sensorHumedadRepository")

public interface ISensorHumedadRepository extends JpaRepository<SensorHumedad, Serializable> {
	
	
	/*@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo WHERE e.idEvento=(:id)")
*/
	@Query("SELECT sh FROM Dispositivo sh WHERE sh.id=(:id)")
	public abstract SensorHumedad findById(int id);

}
