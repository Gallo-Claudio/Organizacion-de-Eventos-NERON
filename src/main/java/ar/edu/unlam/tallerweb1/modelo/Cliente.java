package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    private String nombre;
	
	private String apellido;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Domicilio domicilio;
	
	private Integer telefono;
	
	private Integer dni;
	
	private String email;
	
	private String fechaNacimiento;
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	

}
