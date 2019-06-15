package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class Puntaje {
	
	@Id@GeneratedValue
	private Integer id;
	
	private Integer salon;
	private Integer show;
	private Integer menu;
	private Integer empleados;
	public Integer getSalon() {
		return salon;
	}
	public void setSalon(Integer salon) {
		this.salon = salon;
	}
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}
	public Integer getMenu() {
		return menu;
	}
	public void setMenu(Integer menu) {
		this.menu = menu;
	}
	public Integer getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}
	
	

}
