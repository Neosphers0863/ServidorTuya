package com.example.pedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto_tabla")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;
    @Column(name = "nombre", length = 100, unique = false, nullable = false)
    private String nombre;
    @Column(name = "precio", unique = false, nullable = false)
    private double precio;
    @Column(name = "descripcion", nullable = true)
    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id_tienda")
    @JsonBackReference (value = "tienda-producto")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "fk_detalle", referencedColumnName = "id_detalle")
    @JsonBackReference (value = "producto-detalle")
    private Detalle detalle;

    public Producto() {
    }

    public Producto(Integer id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
