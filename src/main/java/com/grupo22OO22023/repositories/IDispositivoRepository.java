package com.grupo22OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable>{

	public abstract Dispositivo findById(int id);
	
	public abstract Dispositivo findByNombreDispositivo(String nombreDispositivo);
}
