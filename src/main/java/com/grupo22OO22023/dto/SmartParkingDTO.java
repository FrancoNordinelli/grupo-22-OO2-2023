package com.grupo22OO22023.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SmartParkingDTO {
	private int id;
	private String nombreDispositivo;
	private boolean estadoDispositivo;
	private String descripcion;
	private String codigoLugarEstacionamiento;
	private boolean ocupado;
	private LocalDateTime createdAt;
	private int totalVecesOcupado;
	
	public boolean cambiarEstadoOcupado() {
		this.setOcupado(!this.isOcupado());
		return this.isOcupado();
	}
	
	public void aumentarVecesOcupado() {
		setTotalVecesOcupado(getTotalVecesOcupado()+1);
	}
	public void cambiarOcupado() {
		setOcupado(!isOcupado());
	}
}
