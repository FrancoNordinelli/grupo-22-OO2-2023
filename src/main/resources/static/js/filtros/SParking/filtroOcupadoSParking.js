//----->>>>>TODOS LOS FILTROS SE IMPORTAN COMO MODULOS PARA ENCAPSULAR LAS VARIABLES

//talvez lo hace mas modular
let tablaPAraFiltrar = 'cuerpoDispositivos'
let formFiltro = 'filtroSParkingOcupado';
let boton = 'botonFiltroOcupado';
const indiceColumnafiltro = 5;

const tablaDispositivo = document.getElementById(tablaPAraFiltrar);
const filtro = document.getElementById(formFiltro);
const botonFiltrado = document.getElementById(boton);

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
