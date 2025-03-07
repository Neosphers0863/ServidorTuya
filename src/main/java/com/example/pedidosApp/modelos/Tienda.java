package com.example.pedidosApp.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tienda_tabla")

public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Integer id;
    @Column(name = "nombre", length = 100, unique = true, nullable = false)
    private String nombre;
    @Column(name = "direccion", length = 254, unique = true, nullable = false)
    private String direccion;
    @Column(name = "telefono", length = 20, unique = true, nullable = true)
    private String telefono;
    @Column()
    private String categoria;

    public Tienda() {
    }

    public Tienda(Integer id, String nombre, String direccion, String telefono, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
