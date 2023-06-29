package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.Dispositivo;
import com.grupo22OO22023.entities.SensorHumedad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SHEventoModel extends EventoModel{
	
	private boolean regando;

	public SHEventoModel(String nombreEvento, SensorHumedad dispositivo, boolean regando) {
		super(nombreEvento, dispositivo);
		this.regando = regando;
	}

	public SHEventoModel(LocalDateTime createdAt, SensorHumedad dispositivo, boolean regando) {
		super(createdAt, dispositivo);
		this.regando = regando;
	}
	
	

	@Override
	public String toString() {
		return "SHEventoModel [regando=" + regando + "]";
	}

	public SHEventoModel(String nombreEvento, LocalDateTime createdAt, Dispositivo dispositivo, boolean regando) {
		super(nombreEvento, createdAt, dispositivo);
		this.regando = regando;
	}
	
	
	

}
