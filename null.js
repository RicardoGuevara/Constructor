var component0 = document.getElementById('component0');
var component1 = document.getElementById('component1');
var component2 = document.getElementById('component2');
component2.addEventListener('click',sayHello);
function sayError(evt)
{
	alert( "ha ocurrido un error" );
}

function sayHello(evt)
{
	alert( "hola, bienvenido a la p�gina" );
}
