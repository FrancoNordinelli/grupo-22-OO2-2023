package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.entities.Evento;
import com.grupo22OO22023.models.EventoModel;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable>{
	
	public abstract Evento findByidEvento(int idEvento);
	public abstract Evento findByNombreEventoAndDispositivo(String nombreEvento, Dispositivo dispositivo);
	
	public abstract List<Evento> findByNombreEvento(String nombreEvento);
	public abstract List<Evento> findByCreatedAt(LocalDateTime createdAt);
	
	//ver si esto se puede hacer con el dispositivo en concreto, no con dispositivo general.
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo d ORDER BY e.idEvento asc")
	public abstract List<EventoModel> findAllEventosWithAttributes();
	@Query("SELECT e FROM Evento e inner join fetch e.dispositivo d WHERE d.id = (:id) ORDER BY e.idEvento asc")
	public abstract List<Evento> findByDispositivo(@Param("id") int idDispositivo);
	@Query("SELECT e FROM Evento e INNER JOIN FETCH e.dispositivo d WHERE e.nombreEvento=(:nombreEvento) and d.id=(:id)")
	public abstract List<EventoModel> findByNombreEventoAndDispositivo(@Param("nombreEvento") String nombreEvento, @Param("id") int idDispositivo); 
}
