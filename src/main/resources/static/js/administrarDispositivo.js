
function administrarDispostitivo(metodo, body){
	fetch('http://localhost:8080/sparking/', {
		method: metodo,
		body: JSON.stringify(body),
		headers: {"Content-type": "application/json; charset=UTF-8"}
	}).then(function(respuesta){
		console.log(respuesta);
	}).catch((err) => console.log(err))
}

function eliminarDispositivo(){
	const dis = document.getElementById("idDispositivo").innerText;
	administrarDispostitivo("Delete", dis);
	location.href='http://localhost:8080/sparking/';
}

function modificarDispositivo(){
	let id = document.getElementById("idDispositivo").innerText;
	let	nombre = document.getElementById('nombre').value;
	let codigo = null // TODO cuidado aca
	let descripcion = document.getElementById('descripcion').value;
	
	let estadoRadio = document.getElementsByName('estado');
	let estado;
	
	if(estadoRadio[0].checked){
		estado = estadoRadio[0].value;
	} else {
		if(estadoRadio[1].checked){
			estado = estadoRadio[1].value;
		}
	}
	
	const dis = new DispositivoModificacion(nombre, codigo, descripcion, id, estado);
	
	administrarDispostitivo("Put", dis);
	location.replace(location.href);
}
