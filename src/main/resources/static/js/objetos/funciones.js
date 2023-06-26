
function obtenerURL(url, numeroSeparaciones){
	const urlSeparada = url.split('/');
	return urlSeparada[numeroSeparaciones];
}

async function getServer(URL){
	return fetch(URL, {
		method: 'Get'
	}).then(dispositivo => {
		return dispositivo.json();
	}).catch((err) => console.log(err));
}

function putServer(URL, body){
	return fetch(URL, {
		method: 'Put',
		body: JSON.stringify(body),
		headers: {'Content-type': 'application/json; charset=UTF-8'}
	}).then((respuesta) => {
		console.log(respuesta);
	}).catch((err) => console.log(err))
}

function postServer(URL, dispositivo){
	fetch(URL, {
		method: "Post",
		body: JSON.stringify(dispositivo),
		headers: {"Content-type": "application/json; charset=UTF-8"}
	})
	.then(response => response.json())
	.then(response => console.log(response))
	.catch(err => console.log(err))
}
