package com.grupo22OO22023.models;

import com.grupo22OO22023.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SHEventoModel extends EventoModel{
	
	private boolean regando;

	public SHEventoModel(String nombreEvento, Dispositivo dispositivo, boolean regando) {
		super(nombreEvento, dispositivo);
		this.regando = regando;
	}
	
	

}
