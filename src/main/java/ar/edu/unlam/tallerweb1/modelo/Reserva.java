package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Reserva {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	private String fecha;
	
	@ManyToOne
	private Salon salon;
	
	@OneToOne
	private Puntaje puntaje;
	
	
	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	private String zona;
	
	private Integer numeroInvitados;
	
	private Double precio;
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Cliente cliente;
	
	
	private String evento;
	
	private String fingerFood;
	
	private  String bebidas;
	
	
	
	
	
	
	
	
	
	
	
	

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	


	

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}



	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}



	

	public String getFingerFood() {
		return fingerFood;
	}

	public void setFingerFood(String fingerFood) {
		this.fingerFood = fingerFood;
	}

	public String getBebidas() {
		return bebidas;
	}

	public void setBebidas(String bebidas) {
		this.bebidas = bebidas;
	}

	public Integer getNumeroInvitados() {
		return numeroInvitados;
	}

	public void setNumeroInvitados(Integer numeroInvitados) {
		this.numeroInvitados = numeroInvitados;
	}

	

	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	
	
	

	

	
	
	

}
