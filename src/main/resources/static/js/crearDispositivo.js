

function algo(){
	let nombreDis = document.getElementById('nombreDispositivo');
	let descripcion = document.getElementById('descripcion');
	let codigo = document.getElementById('codigoLugarEstacionamiento');
		
	let nDis = new Dispositivo(nombreDis.value, descripcion.value, codigo.value); 
	
	postServer('http://localhost:8080/sparking/', nDis);
	//location.reload();	
};
