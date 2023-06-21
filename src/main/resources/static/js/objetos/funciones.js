
function obtenerURL(url, numeroSeparaciones){
	const urlSeparada = url.split('/');
	return urlSeparada[numeroSeparaciones];
}