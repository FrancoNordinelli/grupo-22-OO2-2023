package com.grupo22OO22023.models;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public abstract class DispositivoModel {
	private int id;
	private boolean estadoDispositivo;
	private String nombreDispositivo;
	private String descripcion;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
	private Set<EventoModel> eventos;

	public DispositivoModel(boolean estadoDispositivo, String nombreDispositivo, String descripcion,
			LocalDateTime updatedAt, LocalDateTime createdAt) {
		super();
		this.nombreDispositivo = nombreDispositivo;
		this.descripcion = descripcion;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.estadoDispositivo = true;
	}
}
