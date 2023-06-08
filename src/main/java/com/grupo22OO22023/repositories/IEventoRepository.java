package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable>{
	
	public abstract Evento findByidEvento(int idEvento);
	
	public abstract List<Evento> findByNombreEvento(String nombreEvento);
	
	public abstract List<Evento> findByDispositivo(Dispositivo dispositivo);
	
	public abstract Evento findByNombreEventoAndDispositivo(String nombreEvento, Dispositivo dispositivo);
}
