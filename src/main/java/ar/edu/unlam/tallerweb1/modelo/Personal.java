package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;	
//	private Date fechaDeIngreso;
//	private String cargo;
//	private Integer sueldoPorEvento;
//	@ManyToMany
//	private List<Evento> evento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Date getFechaDeIngreso() {
//		return fechaDeIngreso;
//	}
//	public void setFechaDeIngreso(Date fechaDeIngreso) {
//		this.fechaDeIngreso = fechaDeIngreso;
//	}
//	public String getCargo() {
//		return cargo;
//	}
//	public void setCargo(String cargo) {
//		this.cargo = cargo;
//	}
//	public Integer getSueldoPorEvento() {
//		return sueldoPorEvento;
//	}
//	public void setSueldoPorEvento(Integer sueldoPorEvento) {
//		this.sueldoPorEvento = sueldoPorEvento;
//	}
//	public List<Evento> getEvento() {
//		return evento;
//	}
//	public void setEvento(List<Evento> evento) {
//		this.evento = evento;
//	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}

