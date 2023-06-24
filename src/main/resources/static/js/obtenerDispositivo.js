
function obtenerDispositivo(){
	const id = obtenerURL(window.location.href, 5);
	
	fetch('http://localhost:8080/sparking/get/' + id, {
		method: 'Get'
	}).then(function(dispositivo){
		return dispositivo.json();
	}).then(function(dispositivo){
		const tabla = document.getElementById('tabla');
		
		const lineaDispositivo = document.createElement("tr");

		let celda = document.createElement('td')
		celda.id="idDispositivo";

		lineaDispositivo.appendChild(celda).textContent = dispositivo.id;
		
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.nombreDispositivo;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.codigoLugarEstacionamiento;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.descripcion;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.estadoDispositivo;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.ocupado;
		lineaDispositivo.appendChild(document.createElement('td')).textContent = dispositivo.createdAt;
		tabla.appendChild(lineaDispositivo);

	}).catch((err) => console.log(err))
}
window.onload = function(){
	obtenerDispositivo();
}
