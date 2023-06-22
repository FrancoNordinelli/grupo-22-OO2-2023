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
}
