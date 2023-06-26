package com.grupo22OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@NoArgsConstructor @ToString
public class SmartParkingModel extends DispositivoModel{
	private String codigoLugarEstacionamiento;
	private boolean ocupado=false;
	private int totalVecesOcupado; 
	
	public SmartParkingModel(boolean estadoDispositivo, String codigoLugarEstacionamiento) {
		super();
		this.codigoLugarEstacionamiento = codigoLugarEstacionamiento;
		this.ocupado = false;
	}
}
