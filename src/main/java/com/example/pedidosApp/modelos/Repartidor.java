package com.example.pedidosApp.modelos;

public class Repartidor {

    private Integer id;
    private String nombre;
    private String telefono;
    private String correoEletronico;
    private String vehiculo;

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
