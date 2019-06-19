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
  
//Funcion del DatePicker
     $.datepicker.regional['es'] = {
     closeText: 'Cerrar',
     prevText: '< Ant',
     nextText: 'Sig >',
     currentText: 'Hoy',
     monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
     monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
     dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
     dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
     dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
     weekHeader: 'Sm',
     dateFormat: 'dd/mm/yy',
     firstDay: 1,
     isRTL: false,
     showMonthAfterYear: false,
     yearSuffix: ''
     };
     $.datepicker.setDefaults($.datepicker.regional['es']);

    $("#fecha").datepicker(); 


$("#boton").click(function(){
	var expr = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
	var nombre = $("#Nombre").val();
    var email = $("#Email").val();
	var dni = $("#Dni").val();
	var fecha = $ ("#fecha").val();

// Validacion nombre y apellido
		if(nombre.length < 10 || nombre.length > 20){
			$("#mensaje1").fadeIn("slow");
			return false;
		}
		else{
			$("#mensaje1").fadeOut();
        }
        
//Validacion Email
        if(email == "" || !expr.test(email)){
            $("#mensaje2").fadeIn("slow");
            return false;
        }
        else{
            $("#mensaje2").fadeOut();
		}

//Validacion Dni

if( !(/^\d{8}$/.test(dni)) || (dni == "")){
	$('#mensaje3').fadeIn("slow");
	return false;
}
else{
$('mensaje3').fadeOut();}

    });
	});