package com.grupo22OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.SHEvento;



@Repository("shEventoRepository")
public interface ISHEventoRepository extends JpaRepository<SHEvento, Serializable> {

	public abstract SHEvento findByIdEvento(int idEvento);
	
	/*@Query("SELECT spe FROM SPEvento spe inner join fetch spe.dispositivo d WHERE d.id = (:id) ORDER BY spe.idEvento asc")
	public abstract List<SPEvento> findByDispositivo(@Param("id") int idDispositivo);*/
	
	@Query("SELECT sh FROM SHEvento sh INNER JOIN FETCH sh.dispositivo d WHERE d.id = (:id)")
	public abstract List<SHEvento> findByDispositivo(@Param("id") int idDis);

}
