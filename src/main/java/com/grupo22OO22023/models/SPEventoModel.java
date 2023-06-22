package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SPEventoModel extends EventoModel{
	private LocalDateTime tiempoOcupado;

	public SPEventoModel(String nombreEvento, Dispositivo dispositivo, LocalDateTime tiempoOcupado) {
		super(nombreEvento, dispositivo);
	}
}
