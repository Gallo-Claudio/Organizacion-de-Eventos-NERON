package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Domicilio {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String calle;
	
	private Integer numeracion;
	
	private String partido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	

}
