//Recursos del HMTL
const tablaDispositivo = document.getElementById('cuerpoDispositivos');
const filtro = document.getElementById('filtroDispositivo');
const botonFiltrado = document.getElementById('botonFiltroEstado');

console.log(tablaDispositivo.rows[0])
const indiceColumnafiltro = 5;

botonFiltrado.addEventListener(('click'), () => {
	for(let indiceFilas = 0; indiceFilas<tablaDispositivo.rows.length; indiceFilas++){
		let filaDispositivo = tablaDispositivo.rows[indiceFilas];
				
		if(filaDispositivo.cells[indiceColumnafiltro].innerText != filtro.value){
			filaDispositivo.style.display='none';
		}else{
			filaDispositivo.style.display='';
		}
	}	
})
