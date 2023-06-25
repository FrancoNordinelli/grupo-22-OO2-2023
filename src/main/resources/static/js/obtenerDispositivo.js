
async function obtenerDispositivo(){
	try{
		let id = obtenerURL(window.location.href, 5);
		let dispositivo = await getServer('http://localhost:8080/sparking/get/' + id);

		const tabla = document.getElementById('tabla');
		const lineaDispositivo = document.createElement('tr');
	
		const celdaID = document.createElement('td');
		lineaDispositivo.appendChild(celdaID).textContent = dispositivo.id;
		console.log(celdaID);	
		celdaID.id="idDispositvo";

		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.nombreDispositivo;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.codigoLugarEstacionamiento;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.descripcion;

		const celdaEstado = document.createElement('td');
		lineaDispositivo.appendChild(celdaEstado).textContent = dispositivo.estadoDispositivo;
		celdaEstado.id = "estado";

		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.ocupado;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.totalVecesOcupado;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.createdAt;
		
		tabla.appendChild(lineaDispositivo);		
	} catch	(err){
		console.log(err);
	}
}
