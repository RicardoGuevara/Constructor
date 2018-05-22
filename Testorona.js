var component0 = document.getElementById('component0');
var component1 = document.getElementById('component1');
component1.addEventListener('click',sayHello);
function sayError(evt)
{
	alert( "ha ocurrido un error" );
}

function sayHello(evt)
{
	alert( "hola, bienvenido a la p�gina" );
}
