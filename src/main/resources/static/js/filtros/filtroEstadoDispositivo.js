//----->>>>>TODOS LOS FILTROS SE IMPORTAN COMO MODULOS PARA ENCAPSULAR LAS VARIABLES


let tablaPAraFiltrar = 'cuerpoDispositivos';
let formFiltro = 'filtroEstadoDispositivo';
let boton = 'botonFiltroEstado';
const indiceColumnafiltro = 4;


//Recursos del HMTL
const tablaDispositivo = document.getElementById(tablaPAraFiltrar);
const filtro = document.getElementById(formFiltro);
const botonFiltrado = document.getElementById(boton);

botonFiltrado.addEventListener(('click'), () => {
	for(let indiceFilas = 0; indiceFilas<tablaDispositivo.rows.length; indiceFilas++){
		let filaDispositivo = tablaDispositivo.rows[indiceFilas];
				
		console.log(filaDispositivo.cells[indiceColumnafiltro].innerText)
				
		if(filtro.value == 'todos'){
			filaDispositivo.style.display='';
		}else{
			if(filaDispositivo.cells[indiceColumnafiltro].innerText.trim() != filtro.value){
				filaDispositivo.style.display='none';
			}else{
				filaDispositivo.style.display='';
			}
		}
	}	
})

