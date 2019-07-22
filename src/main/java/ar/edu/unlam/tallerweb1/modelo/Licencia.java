package ar.edu.unlam.tallerweb1.modelo;


	import java.time.LocalDate;
import java.util.Date;
import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;

	import org.hibernate.annotations.LazyCollection;
	import org.hibernate.annotations.LazyCollectionOption;

	@Entity
	public class Licencia {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long idLicencia;
		
		private LocalDate fechasLicencias;

		@ManyToMany
		@JoinTable(name = "personallicencia", joinColumns = @JoinColumn(name = "idLicencia"), inverseJoinColumns = @JoinColumn(name = "idPersonal"))
		private List <Personal> personal_licencia;

//		@ManyToMany(mappedBy = "licencia")
//		private List<Reserva> reserva;
//		
		
	    public List<Personal> getPersonal_licencia() {
			return personal_licencia;
		}

		public void setPersonal_licencia(List<Personal> personal_licencia) {
			this.personal_licencia = personal_licencia;
		}

		
		//Getters y Setter
		
	
		public Long getIdLicencia() {
			return idLicencia;
		}

		public LocalDate getFechasLicencias() {
			return fechasLicencias;
		}

		public void setFechasLicencias(LocalDate fechasLicencias) {
			this.fechasLicencias = fechasLicencias;
		}

		public void setIdLicencia(Long idLicencia) {
			this.idLicencia = idLicencia;
		}
}