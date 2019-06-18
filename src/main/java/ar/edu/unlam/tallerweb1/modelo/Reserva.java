package ar.edu.unlam.tallerweb1.modelo;

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

	@ManyToOne
	private FingerFood fingerFood;
	
	@ManyToOne
	private Entrada entrada;
	
	@ManyToOne
	private PlatoPrincipal platoPrincipal;
	
	@ManyToOne
	private Bebida bebida;
	
	@ManyToOne
	private Postre postre;
	
	@ManyToOne
	private MesaDulce mesaDulce;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FingerFood getFingerFood() {
		return fingerFood;
	}
	public void setFingerFood(FingerFood fingerFood) {
		this.fingerFood = fingerFood;
	}
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	public PlatoPrincipal getPlatoPrincipal() {
		return platoPrincipal;
	}
	public void setPlatoPrincipal(PlatoPrincipal platoPrincipal) {
		this.platoPrincipal = platoPrincipal;
	}
	public Bebida getBebida() {
		return bebida;
	}
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	public Postre getPostre() {
		return postre;
	}
	public void setPostre(Postre postre) {
		this.postre = postre;
	}
	public MesaDulce getMesaDulce() {
		return mesaDulce;
	}
	public void setMesaDulce(MesaDulce mesaDulce) {
		this.mesaDulce = mesaDulce;
	}
	
}
