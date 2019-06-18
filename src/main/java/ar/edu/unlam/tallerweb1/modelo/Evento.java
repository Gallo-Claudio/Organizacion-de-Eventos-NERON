package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	private LocalDate fechaDelEvento;
	@ManyToMany
	private List <Personal> personal;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public LocalDate getFechaDelEvento() {
//		return fechaDelEvento;
//	}
//	public void setFechaDelEvento(LocalDate fechaDelEvento) {
//		this.fechaDelEvento = fechaDelEvento;
//	}
	public List<Personal> getPersonal() {
		return personal;
	}
	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}


	
}
