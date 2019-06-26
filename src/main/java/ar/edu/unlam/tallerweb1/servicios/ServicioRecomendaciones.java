package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.ArrayList;
import java.util.List;

public interface ServicioRecomendaciones {

    ArrayList<ArrayList<Menu>> ObtenerRecomendaciones();
}
