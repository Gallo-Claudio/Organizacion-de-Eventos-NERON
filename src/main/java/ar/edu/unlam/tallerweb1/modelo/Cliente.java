package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

//    @OneToOne
//    private UbicacionCliente ubicacion;

    public Cliente(){}

    public Cliente(String nombre,String apellido,String dni) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;

    }

    public Long getId() {
        return id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

//    public UbicacionCliente getUbicacion() {
//        return ubicacion;
//    }

//   public void setUbicacion(UbicacionCliente ubicacion) {
//        this.ubicacion = ubicacion;
//    }
}


