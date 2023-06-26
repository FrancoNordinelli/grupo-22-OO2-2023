//-------------------------------------------------
//Alta/Baja lógica de dispositivo
//-------------------------------------------------

//Obtengo de forma general el ID
const id = document.getElementById('idDispositivo').innerText;

//Obtengo el HTML del boton que segun el etado del dispositivo va a cambiar su función
const estadoDispositivo = document.getElementById('estadoDispositivo');

//Segun el estado del dispostivo, cambia el value del boton
if(estadoDispositivo.innerText == 'true'){
	document.getElementById('botonMultiple').value='Desactivar';
} else {
	document.getElementById('botonMultiple').value='Activar';
}

//Cambio del href del boton segun su estado y recarga de la pagina
document.getElementById('botonMultiple').addEventListener('click', (evento) => {
	
	const formularioAB = document.getElementById('formABDispostivo');
	
	switch(botonMultiple.value){
		case 'Activar':
			formularioAB.action = "/sparking/activar/" + id;
			formularioAB.submit();			
			break;
		case 'Desactivar':
			formularioAB.action = "/sparking/desactivar/" + id;
			formularioAB.submit();
			break;
		default:
			console.log('Error en el valor del boton multiple.');
	}
})

//-------------------------------------------------
//modificacion de dispositivo
//-------------------------------------------------

//Obtengo los datos que se van a modificar, el boton de modificación y el formulario
const campoNombre = document.getElementById('nombre');
const campoDescripcion = document.getElementById('descripcion');
const botonModificar = document.getElementById('botonModificar');
const formularioModificacion = document.getElementById('formularioModificacion');

//Comprobación de los campos de modificación del dispositivo
botonModificar.addEventListener('click', (evento) => {
	
	if(campoNombre.validity.valid && campoDescripcion.validity.valid){
		formularioModificacion.action="/sparking/modificar/" + id;
		formularioModificacion.submit();
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
})
