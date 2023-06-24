
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
	let nombre = document.getElementById('nombre').value;
	let descripcion = document.getElementById('descripcion').value;
	
	let estadoRadio = document.getElementsByName('estado');
	let estado = true;
	if(estadoRadio[1].checked) estado = estadoRadio[1].value;
	
	const dis = new DispositivoModificacion(nombre, null, descripcion, id, estado);
	administrarDispostitivo("Put", dis);
	//location.replace(location.href);
}

const campoNombre = document.getElementById('nombre');
const campoDescripcion = document.getElementById('descripcion');
const botonModificar = document.getElementById('botonModificar');

botonModificar.addEventListener("click", () => {
	if(campoNombre.validity.valid){ 
		if (campoDescripcion.validity.valid){
			modificarDispositivo();
			console.log("todo ok");
		} else {
			mostrarError();
		}
	} else {
		mostrarError();
	}
	
	function mostrarError(){
		if(campoNombre.validity.valueMissing){
			campoNombre.setCustomValidity("Error, el nombre es necesario.");
			console.log("Error, el nombre es necesario.")
		}
		if(campoDescripcion.validity.valueMissing){
			campoNombre.setCustomValidity("Error, la descripcion es necesaria.");
			console.log("Error, la descripcion es necesaria.");
		}
	}
})


const botonEliminar = document.getElementById('botonEliminar');
botonEliminar.addEventListener("click", () => {
	eliminarDispositivo();
})