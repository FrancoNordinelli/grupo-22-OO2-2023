package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SPEventoModel extends EventoModel{
	private long horasOcupado;

	public SPEventoModel(String nombreEvento, Dispositivo dispositivo) {
		super(nombreEvento, dispositivo);
	}
	public SPEventoModel(LocalDateTime createdAt, Dispositivo dispositivo) {
		super(createdAt, dispositivo);
	}
	
}
