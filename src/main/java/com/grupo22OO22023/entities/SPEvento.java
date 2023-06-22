package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SPEvento extends Evento{
	private LocalDateTime tiempoOcupado;

	public SPEvento(String nombreEvento, Dispositivo dispositivo, LocalDateTime tiempoOcupado) {
		super(nombreEvento, dispositivo);
		this.tiempoOcupado = tiempoOcupado;
	}
}
