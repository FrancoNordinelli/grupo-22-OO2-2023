
function crearDispositivo(dispositivo){
	fetch('http://localhost:8080/sparking/', {
		method: "Post",
		body: JSON.stringify(dispositivo),
		headers: {"Content-type": "application/json; charset=UTF-8"}
	})
	.then(response => response.json())
	.then(response => console.json(response))
	.catch(err => console.log(err))	
};

function algo(){
	let nombreDis = document.getElementById('nombreDispositivo');
	let descripcion = document.getElementById('descripcion');
	let codigo = document.getElementById('codigoLugarEstacionamiento');
		
	let nDis = new Dispositivo(nombreDis.value, descripcion.value, codigo.value); 
	
	crearDispositivo(nDis);

	location.reload();	
};
