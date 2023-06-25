
function obtenerDispositivos(){
	fetch('http://localhost:8080/sparking/getAll',{
		method: 'Get'
	}).then(function(dispositivos){
		return dispositivos.json();	
	}).then(function (dispositivos){
		const table = document.getElementById('listaDispostivos');
		for (const dispositivo of dispositivos){
			const lineaDispositivo = document.createElement("tr");
			
			//ver si se puede mejorar o almenos acortar lineas
			
			var td = document.createElement("td");
			var a = document.createElement("a");
			
			a.href = 'http://localhost:8080/sparking/eventos/' + dispositivo.id;
			a.textContent=dispositivo.id;
			td.appendChild(a);
			
			lineaDispositivo.appendChild(td);
			lineaDispositivo.appendChild(document.createElement("td")).textContent = dispositivo.nombreDispositivo;
			lineaDispositivo.appendChild(document.createElement("td")).textContent = dispositivo.codigoLugarEstacionamiento;
			lineaDispositivo.appendChild(document.createElement("td")).textContent = dispositivo.descripcion;
			lineaDispositivo.appendChild(document.createElement("td")).textContent = dispositivo.estadoDispositivo;
			lineaDispositivo.appendChild(document.createElement("td")).textContent = dispositivo.ocupado;
			table.appendChild(lineaDispositivo);
		}
	}).catch(function(err){
		console.log(err);
	})
}

window.onload = function() {
	obtenerDispositivos();
}
