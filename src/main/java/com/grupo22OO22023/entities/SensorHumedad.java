package com.grupo22OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "sensorHumedad")
public class SensorHumedad extends Dispositivo {
	
	@Column
	private String ubicacion;
	@Column
	private String lectura;
	@Column
	private boolean estado;
	@Column
	private String sensor;
	public SensorHumedad(@NotNull String nombreDispositivo, @NotNull boolean estadoDispositivo,
			@NotNull String descripcion, String ubicacion, String lectura, boolean estado, String sensor) {
		super(nombreDispositivo, estadoDispositivo, descripcion);
		this.ubicacion = ubicacion;
		this.lectura = lectura;
		this.estado = estado;
		this.sensor = sensor;
	}
	@Override
	public String toString() {
		return "SensorHumedad [ubicacion=" + ubicacion + ", lectura=" + lectura + ", estado=" + estado + ", sensor="
				+ sensor + "]" + super.toString();
	}
	
	
	
	

}
