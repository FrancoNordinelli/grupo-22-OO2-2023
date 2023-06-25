
/*
function administrarDispostitivo(metodo, body, url){
	fetch('http://localhost:8080/sparking/' + url, {
		method: metodo,
		body: JSON.stringify(body),
		headers: {'Content-type': 'application/json; charset=UTF-8'}
	}).then(function(respuesta){
		console.log(respuesta);
	}).catch((err) => console.log(err))
}*/


function activarDispositivo(id){
	putServer('http://localhost:8080/sparking/activar', id);
	
	//location.href='http://localhost:8080/sparking/';
}
function desactivarDispositivo(id){
	putServer('http://localhost:8080/sparking/desactivar', id);
	
	//location.href='http://localhost:8080/sparking/';
}
function modificarDispositivo(){
	let id = document.getElementById('idDispositivo').innerText;	
	let nombre = document.getElementById('nombre').value;
	let descripcion = document.getElementById('descripcion').value;
	
	let estadoRadio = document.getElementsByName('estado');
	let estado = true;
	if(estadoRadio[1].checked) estado = estadoRadio[1].value;
	
	const dispositivo = new DispositivoModificacion(nombre, null, descripcion, id, estado);
	putServer('http://localhost:8080/sparking/activar', dispositivo);

	location.replace(location.href);
}
	
obtenerDispositivo()
document.addEventListener('DOMContentLoaded', () => {

	const seccionDeBotonesAB = document.getElementById('redondeo');
	const botonMultiple = document.createElement('input');
	const campoNombre = document.getElementById('nombre');
	const campoDescripcion = document.getElementById('descripcion');
	const botonModificar = document.getElementById('botonModificar');
	const estadoDispositivo = document.getElementById('estado');
	
	console.log(estadoDispositivo);
	/*
	botonMultiple.id='botonMultiple';
	botonMultiple.type='button';
	if(estadoDispositivo.textContent){
		botonMultiple.value='Desactivar';
	} else {
		botonMultiple.value='Activar';
	}
	
	seccionDeBotonesAB.appendChild(botonMultiple)
	
	botonMultiple.addEventListener('click', () => {
		switch(botonMultiple.value){
			case 'Desactivar':
				desactivarDispositivo(document.getElementById('idDispositvo'));
				break;
			case 'Activar':
				activarDispositivo(document.getElementById('idDispositvo'));
				break;
			default:
				console.log('Error en el valor del boton multiple.');
		}
	})
	botonModificar.addEventListener('click', () => {
		if(campoNombre.validity.valid){ 
			if (campoDescripcion.validity.valid){
				modificarDispositivo();
				console.log('todo ok');
			} else {
				mostrarError();
			}
		} else {
			mostrarError();
		}
		
		function mostrarError(){
			if(campoNombre.validity.valueMissing){
				campoNombre.setCustomValidity('Error, el nombre es necesario.');
				console.log('Error, el nombre es necesario.')
			}
			if(campoDescripcion.validity.valueMissing){
				campoNombre.setCustomValidity('Error, la descripcion es necesaria.');
				console.log('Error, la descripcion es necesaria.');
			}
		}
	})*/
})



















