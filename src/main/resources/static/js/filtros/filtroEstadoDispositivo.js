//----->>>>>TODOS LOS FILTROS SE IMPORTAN COMO MODULOS PARA ENCAPSULAR LAS VARIABLES

//Recursos del HMTL
const tablaDispositivo = document.getElementById('cuerpoDispositivos');
const filtro = document.getElementById('filtroDispositivo');
const botonFiltrado = document.getElementById('botonFiltroEstado');

const indiceColumnafiltro = 4;

botonFiltrado.addEventListener(('click'), () => {
	for(let indiceFilas = 0; indiceFilas<tablaDispositivo.rows.length; indiceFilas++){
		let filaDispositivo = tablaDispositivo.rows[indiceFilas];
				
		if(filtro.value == 'todos'){
			filaDispositivo.style.display='';
		}else{
			if(filaDispositivo.cells[indiceColumnafiltro].innerText != filtro.value){
				filaDispositivo.style.display='none';
			}else{
				filaDispositivo.style.display='';
			}
		}
	}	
})

