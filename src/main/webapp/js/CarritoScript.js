$(document).ready(function() {

//Funcion del carrito*/
  $("#cant").click(function() {
     subtotal(); 
    });

  $("#cant2").click(function() {
     subtotal2(); 
    });

  $("#cant3").click(function() {
     subtotal3(); 
    });

 //funcion que hace el subtotal con Jquery
   function subtotal() { 
    	var sub = 3599; //Precio del primer reloj
 
    $('#cant').click(function(){
		$("#subT").val(parseInt($('#cant').val()) * sub); //Multiplico la cantidad por el total del precio
            });
    total();
}

	function subtotal2(){
		var sub2 = 6799; //Precio del segundo reloj
		$('#cant2').click(function(){
    		$("#subT2").val(parseInt($('#cant2').val()) * sub2);
            });
      total();
	}

	function subtotal3(){
		var sub3 = 4899; //Precio del tercer reloj
		$('#cant3').click(function(){
    		$("#subT3").val(parseInt($('#cant3').val()) * sub3);
            });
      total();
	}

 //funcion que calcula el total de los productos
	function total () {
		var tot = parseInt($('#subT').val());
		var tot2 = parseInt($('#subT2').val());
		var tot3 = parseInt($('#subT3').val());
    $("#Tot").val(parseInt(tot+tot2+tot3));
	}
  total();
  
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
});