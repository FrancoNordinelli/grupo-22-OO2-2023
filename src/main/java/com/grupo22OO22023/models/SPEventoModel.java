package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.SmartParking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SPEventoModel extends EventoModel{
	private long horasOcupado;

	public SPEventoModel(String nombreEvento, SmartParking dispositivo) {
		super(nombreEvento, dispositivo);
	}
	public SPEventoModel(LocalDateTime createdAt, SmartParking dispositivo) {
		super(createdAt, dispositivo);
	}
}
