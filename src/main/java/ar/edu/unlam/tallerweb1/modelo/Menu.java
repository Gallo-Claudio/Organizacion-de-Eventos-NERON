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
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;
	private Integer costo;
	@ManyToOne
	private TipoDeMenu tipoDeEvento;
<<<<<<< HEAD
	@OneToMany
	private List<PuntajeMenu> puntajes;
	public Menu(){}
=======
	
	
	@ManyToMany
	private List<ReservaMultiple> reservaMultiple;              
	
	
	
>>>>>>> gallo
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public TipoDeMenu getTipoDeEvento() {
		return tipoDeEvento;
	}

	public void setTipoDeEvento(TipoDeMenu tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}
<<<<<<< HEAD

	public List<PuntajeMenu> getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(List<PuntajeMenu> puntajes) {
		this.puntajes = puntajes;
	}
=======
	public List<ReservaMultiple> getReservaMultiple() {
		return reservaMultiple;
	}
	public void setReservaMultiple(List<ReservaMultiple> reservaMultiple) {
		this.reservaMultiple = reservaMultiple;
	}
	
	
>>>>>>> gallo
}
