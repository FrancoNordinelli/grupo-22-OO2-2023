package com.grupo22OO22023.models;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@NoArgsConstructor @ToString
public class SmartParkingModel {
	
	private int id;
	private boolean estadoDispositivo;
	private String codigoLugarEstacionamiento;
	private boolean ocupado;
	
	private Set<EventoModel> evento;
	
	public SmartParkingModel(boolean estadoDispositivo, String codigoLugarEstacionamiento, boolean ocupado) {
		super();
		this.estadoDispositivo = estadoDispositivo;
		this.codigoLugarEstacionamiento = codigoLugarEstacionamiento;
		this.ocupado = ocupado;
	}

	public SmartParkingModel(String codigoLugarEstacionamiento) {
		super();
		this.estadoDispositivo = true;
		this.codigoLugarEstacionamiento = codigoLugarEstacionamiento;
		this.ocupado = false;
	}
}
