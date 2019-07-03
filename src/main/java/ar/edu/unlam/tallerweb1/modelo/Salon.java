package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer capacidadMaxima;
    private String direccion;
     
    public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	//imagen para el card
    private String imagenCard;

    private Double puntaje;


    @OneToOne
    private Zona zona;
   @OneToMany(mappedBy="salon")
    private List<Reserva> reserva;

    @OneToMany
    private List<Imagenes> Imagenes;


    public Salon() {

    }


    public Salon(String nombre,Double precio,Integer capacidadMaxima) {
        this.nombre=nombre;
        this.precio=precio;
        this.capacidadMaxima=capacidadMaxima;





    }


  // public void agregarReservas(Reserva reserva){
   //     this.reserva.add(reserva);
 //  }

    public String getImagenCard() {
        return imagenCard;
    }

    public void setImagenCard(String imagenCard) {
        this.imagenCard = imagenCard;
    }

    public Long getId() {
		return id;
	}

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioPorInvitado() {
        return precio;
    }

    public void setPrecioPorInvitado(Double precioPorInvitado) {
        this.precio= precioPorInvitado;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

   public void setReserva(List<Reserva> reserva) {
       this.reserva = reserva;
  }



    public List<Imagenes> getImagenes() {
        return Imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
        Imagenes = imagenes;
    }


}
