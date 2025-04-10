package com.example.pedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "repartidor_tabla")

public class Repartidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repartidor")
    private Integer id;
    @Column(name = "nombre", length = 100, unique = true, nullable = false)
    private String nombre;
    @Column(name = "telefono", length = 20, unique = true, nullable = false)
    private String telefono;
    @Column(name = "correoEletronico", length = 150, unique = true, nullable = false)
    private String correoEletronico;
    @Column(name = "vehiculo", length = 50, unique = true, nullable = false)
    private String vehiculo;

    @OneToMany(mappedBy = "repartidor")
    @JsonManagedReference
    private List<Entrega> entrega;

    public Repartidor() {
    }

    public Repartidor(Integer id, String nombre, String telefono, String correoEletronico, String vehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoEletronico = correoEletronico;
        this.vehiculo = vehiculo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoEletronico() {
        return correoEletronico;
    }

    public void setCorreoEletronico(String correoEletronico) {
        this.correoEletronico = correoEletronico;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}
