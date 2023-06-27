package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.Evento;

@Repository("EventoGenericoRepository")
public interface IEventoGenericoRepository extends JpaRepository<Evento, Serializable>{
	public abstract Evento findByIdEvento(int idEvento);
	public abstract List<Evento> findByNombreEvento(String nombre);
	public abstract List<Evento> findByCreatedAt(LocalDateTime createdAt);
	
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo WHERE e.idEvento=(:id)")
	public abstract Evento findByIdEventoAndInicializeDependencies(int id);
}
