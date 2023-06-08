package com.grupo22OO22023.models;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class DispositivoModel {
	private int id;
	private boolean estadoDispositivo;
	private String nombreDispositivo;
	@ToString.Exclude
	private Set<EventoModel> eventos;
	
	public DispositivoModel(boolean estadoDispositivo) {
		super();
		this.estadoDispositivo = estadoDispositivo;
	}
}
