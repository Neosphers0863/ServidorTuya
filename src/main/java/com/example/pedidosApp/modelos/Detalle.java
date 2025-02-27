package com.example.pedidosApp.modelos;

public class Detalle {

    private Integer id;
    private int cantidad;
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
