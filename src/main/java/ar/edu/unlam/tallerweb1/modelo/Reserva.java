package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String horario;
	@OneToOne
	private Extras Extras;

    @ManyToOne
    private Salon salon;

    @OneToOne
    private Cliente cliente;


    public Reserva() {

    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
	public ar.edu.unlam.tallerweb1.modelo.Extras getExtras() {
		return Extras;
	}

	public void setExtras(ar.edu.unlam.tallerweb1.modelo.Extras extras) {
		Extras = extras;
	}
}
