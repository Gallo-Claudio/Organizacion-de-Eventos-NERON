package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Menu2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private Integer precio;
//	@ManyToOne
//	private TipoDeMenu tipoDeEvento;
	@ManyToMany
	private List<Reserva> reserva;
	
	
	
	public Menu2(){}
              



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

//	public TipoDeMenu getTipoDeEvento() {
//		return tipoDeEvento;
//	}

//	public void setTipoDeEvento(TipoDeMenu tipoDeEvento) {
//		this.tipoDeEvento = tipoDeEvento;
//	}

	public List<Reserva> getReserva() {
		return reserva;
	}
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;

	}

}
