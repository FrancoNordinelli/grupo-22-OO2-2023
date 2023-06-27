package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.SPEvento;

@Repository("spEventoRepository")
public interface ISPEventoRepository extends JpaRepository<SPEvento, Serializable>{
	//Generico
	public abstract SPEvento findByidEvento(int idEvento);
	
	@Query("SELECT spe FROM SPEvento spe INNER JOIN FETCH spe.dispositivo d WHERE spe.nombreEvento=(:nombre) and spe.dispositivo.id=(:id)")
	public abstract List<SPEvento> findByNombreEventoAndDispositivo(@Param("nombre") String nombreEvento, @Param("id") int id);
	public abstract List<SPEvento> findByNombreEvento(String nombreEvento);
	public abstract List<SPEvento> findByCreatedAt(LocalDateTime createdAt);
	
	@Query("SELECT spe FROM SPEvento spe INNER JOIN FETCH spe.dispositivo d ORDER BY spe.idEvento asc")
	public abstract List<SPEvento> findAllEventosWithDependencies();
	@Query("SELECT spe FROM SPEvento spe inner join fetch spe.dispositivo d WHERE d.id = (:id) ORDER BY spe.idEvento asc")
	public abstract List<SPEvento> findByDispositivo(@Param("id") int idDispositivo);
	
	//Especifico
	@Query("SELECT spe FROM SPEvento spe INNER JOIN FETCH spe.dispositivo d ORDER BY spe.horasOcupado asc")
	public abstract SPEvento findByDispositivoOrderByHoras(@Param("id") int id);

	@Query("SELECT spe FROM SPEvento spe INNER JOIN FETCH spe.dispositivo d WHERE d.id = (:id) ORDER BY spe.idEvento desc")
	public abstract List<SPEvento> findByIdDispositivoOrderedByIdDispositivoDESC(@Param("id") int id);
	
	@Query("SELECT COUNT(spe.idEvento) FROM SPEvento spe")
	public abstract int cantEventos();
	
}
