//----->>>>>TODOS LOS FILTROS SE IMPORTAN COMO MODULOS PARA ENCAPSULAR LAS VARIABLES

let tablaPAraFiltrar = 'cuerpoDispositivos';
let formFiltro = 'filtradoPorDescripcion';
let boton = 'botonFiltroDescripcion';
const indiceColumnafiltro = 3;

//Recursos del HMTL
const tablaDispositivo = document.getElementById(tablaPAraFiltrar);
const filtro = document.getElementById(formFiltro);
const botonFiltrado = document.getElementById(boton);

botonFiltrado.addEventListener(('click'), () => {
	for(let indiceFilas = 0; indiceFilas<tablaDispositivo.rows.length; indiceFilas++){
		let filaDispositivo = tablaDispositivo.rows[indiceFilas];
		
		if(filtro.value == ''){
			filaDispositivo.style.display='';
		}else{
			if(filaDispositivo.cells[indiceColumnafiltro].innerText == filtro.value){
				filaDispositivo.style.display='';
			}else{
				filaDispositivo.style.display='none';
			}
		}
		
		
		
		/*
		if(filtro.value == 'todos'){
			filaDispositivo.style.display='';
		}else{
			if(filaDispositivo.cells[indiceColumnafiltro].innerText != filtro.value){
				filaDispositivo.style.display='none';
			}else{
				filaDispositivo.style.display='';
			}
		}*/
	}	
})