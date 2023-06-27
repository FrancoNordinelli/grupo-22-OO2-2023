package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SensorHumedadModel extends DispositivoModel {

	private String ubicacion;

	private String lectura;

	private boolean estado;

	private String sensor;

	public SensorHumedadModel(boolean estadoDispositivo, String nombreDispositivo, String descripcion,
			LocalDateTime updatedAt, LocalDateTime createdAt, String ubicacion, String lectura, boolean estado,
			String sensor) {
		super(estadoDispositivo, nombreDispositivo, descripcion, updatedAt, createdAt);
		this.ubicacion = ubicacion;
		this.lectura = lectura;
		this.estado = estado;
		this.sensor = sensor;
	}

}
