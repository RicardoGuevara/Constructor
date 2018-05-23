var component0 = document.getElementById('component0');
var component1 = document.getElementById('component1');
component0.addEventListener('click',sayHello);
component1.addEventListener('click',sayError);
function sayError(evt)
{
	alert( "ha ocurrido un error" );
}

function sayHello(evt)
{
	alert( "hola, bienvenido a la p�gina" );
}
