package com.example.pedidosApp.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_tabla")

public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id;
    @Column(name = "cantidad", unique = true, nullable = false)
    private int cantidad;
    @Column(name = "subtotal", precision = 10, scale = 2, unique = true, nullable = false)
    private double subTotal;

    public Detalle() {
    }

    public Detalle(Integer id, int cantidad, double subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
