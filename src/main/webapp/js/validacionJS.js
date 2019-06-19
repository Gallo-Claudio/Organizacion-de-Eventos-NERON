$(document).ready(function(){

//Funcion del autocomplete
 $( function Validacion() {
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

     $("#datepicker").datepicker(); 

});  


function Validacion(){
 
		var nombreapellido = document.getElementById('nombre').value;
		var email = document.getElementById('email').value;
		var dni = document.getElementById('dni').value;
		var naci = document.getElementById('datepicker').value;
		var checkBox = document.getElementById('checkBox').value;
        
  
// Validación de nombre y apellido
		if((nombreapellido == null) || (nombreapellido.length < 10) || (nombreapellido.length >= 20)){
			alert('Por favor, ingrese su nombre.\nDebe tener como minimo 10 caracteres y 20 como máximo.');
            document.form.dni.focus();
			return false;
		}
  
// Validación de Email
		if(!(/\S+@\S+\.\S+/.test(email))){
			alert('Por favor, ingrese su correo electrónico.\nEjemplo: usuario@dominio.com');
            document.form.email.focus();
			return false;
		}  
 
// Validación de DNI
	if( !(/^\d{8}$/.test(dni)) || (dni == "")){
            alert("Por favor, ingrese un dni válido (8 dígitos).");
       return false; 
	   }
    if(!checkBox.checked){
			alert('Por favor, debe aceptar las condiciones.');
			return false
		}
	return true;
}