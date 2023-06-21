class Dispositivo {
	constructor(nombreDispositivo, descripcion, codigoLugarEstacionamiento){
		this.nombreDispositivo = nombreDispositivo;
		this.descripcion = descripcion;
		this.codigoLugarEstacionamiento = codigoLugarEstacionamiento;
	}
	
}

class DispositivoModificacion extends Dispositivo{
	constructor(nombreDispositivo, codigoLugarEstacionamiento, descripcion, id, estado){
		super(nombreDispositivo, descripcion, codigoLugarEstacionamiento);
		this.id = id;
		this.estadoDispositivo = estado;
	}
}
