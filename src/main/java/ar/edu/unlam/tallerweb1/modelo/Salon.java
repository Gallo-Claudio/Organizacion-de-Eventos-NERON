package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer capacidadMaxima;


    @OneToOne
    private UbicacionSalon ubicacion;
    @OneToMany(mappedBy="salon")
    private List<Reserva> reserva;

  //  @OneToMany
  //  private List<Imagenes> Imagenes;


    public Salon() {

    }


    public Salon(String nombre,Double precio,Integer capacidadMaxima) {
        this.nombre=nombre;
        this.precio=precio;
        this.capacidadMaxima=capacidadMaxima;


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public UbicacionSalon getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionSalon ubicacion) {
        this.ubicacion = ubicacion;
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

  /*  public List<Imagenes> getImagenes() {
        return Imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
        Imagenes = imagenes;
    }*/


}
