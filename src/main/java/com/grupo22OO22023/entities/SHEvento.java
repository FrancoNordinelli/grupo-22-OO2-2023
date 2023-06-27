package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "shEvento")
public class SHEvento extends Evento{
	
	@Column
	private boolean regando;

	public SHEvento(String nombreEvento, SensorHumedad dispositivo, boolean regando) {
		super(nombreEvento, dispositivo);
		this.regando = regando;
	}
	
	public SHEvento(LocalDateTime createdAt, SensorHumedad dispositivo) {
		super(createdAt, dispositivo);
	}
	
	
}
