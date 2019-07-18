	<nav class="navbar navbar-default" role="navigation">
		<!-- El logotipo y el icono que despliega el menú se agrupan
         para mostrarlos mejor en los dispositivos móviles -->
		<div class="logotipo-encabezado"></div>

		<!-- Agrupar los enlaces de navegación, los formularios y cualquier
         otro elemento que se pueda ocultar al minimizar la barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a class="btn" href="home">Inicio</a></li>
				<li><a class="btn" href="salones-a-puntuar">Nuestros Salones</a></li>
				<li><a class="btn" href="menus-a-puntuar">Nuestros Menus</a></li>			
				<li><a class="btn" href="eventos-pendientes-cliente">Ver detalles de la/s Reserva/s</a></li>
				<li><a class="btn" href="condiciones-cancelacion-reserva">Cancelar Reserva</a></li>
			
				<!--<form class="form-btn" method="post" action="eventos-pendientes-cliente">
					<input type="submit" value="Resumen de eventos" class="btn">
				</form>-->
			</ul>
			
			<div class="navbar-form navbar-left">
            <h5>Bienvenido: ${usuario}</h5>
            </div>
			<div class="navbar-form navbar-left">
				<h5>Organización de Eventos NERON</h5>
			</div>


			<form class="navbar-form navbar-left" method="post"
				action="cerrarsesion">
				<div class="form-group">
					<input type="submit" value="cerrar sesion" class="btn btn-danger">
				</div>
			</form>

		</div>
	</nav>