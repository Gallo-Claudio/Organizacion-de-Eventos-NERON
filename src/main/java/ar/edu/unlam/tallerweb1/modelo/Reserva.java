package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String horario;
    private Integer cantidadDeInvitados;
	@OneToMany
	private List<Extras> extras;

    @ManyToOne
    private Salon salon;

    @OneToOne
    private Usuario usuario;

	@OneToMany
	private List<PuntajeMenu> puntajesMenu;

	@ManyToMany
	private List<Menu> menu;


	@ManyToMany
	private List <Personal> personal;



    public Reserva() {

    }

	public List<PuntajeMenu> getPuntajesMenu() {
		return puntajesMenu;
	}

	public Integer getCantidadDeInvitados() {
		return cantidadDeInvitados;
	}

	public void setCantidadDeInvitados(Integer cantidadDeInvitados) {
		this.cantidadDeInvitados = cantidadDeInvitados;
	}

	public void setPuntajesMenu(List<PuntajeMenu> puntajesMenu) {
		this.puntajesMenu = puntajesMenu;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}







	public List<Extras> getExtras() {
		return extras;
	}

	public void setExtras(List<Extras> extras) {
		this.extras = extras;
	}

	public Salon getSalon() {
		return salon;
	}



	public void setSalon(Salon salon) {
		this.salon = salon;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Menu> getMenu() {
		return menu;
	}



	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}



	public List<Personal> getPersonal() {
		return personal;
	}



	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}


}

