$(document).ready(function() {

//Funcion del autocomplete
 $( function autocompletar() {
    var availableTags = [
     "Reloj Puma Liberated",
	 "Reloj Ona Saez gmorne",
	 "Reloj Puma Road Precision",
	 "Reloj Ona Saez lmsacne",
	 "Reloj Puma Matchplay",
	 "Reloj Ona Saez Golden Acero Malla De Cuero Bisel",
	 "Reloj Puma Ultrasize Malla Silicona",
	 "Reloj Ona Saez  Analogico Carcasa Acero Cuero",
	 "Reloj Puma Suede Ladies",
	 "Reloj Ona Saez Colour Collection Acero Wr"
    ];

    $( "#tags" ).autocomplete({
      source: availableTags
    });
  });



//Fucion del carrito*/
  $(".carrito").click(function() {
	if ($("#cuenta").val()<=15) {
      incrementar(); 
    }
     else{
        alert("Ha alcanzado el numero maximo de productos en su carrito")
     } 
    });

//funcion que incrementa con Jqeury
   function incrementar() {  
    var valor = $("#cuenta").val();
    $("#cuenta").val(parseInt(valor)+1);
}
   });