package com.example.pedidosApp.modelos;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Pedido {

    private Integer id;
    private LocalDate fechapedido;
    private double total;

    public Pedido() {
    }

    public Pedido(Integer id, LocalDate fechapedido, double total) {
        this.id = id;
        this.fechapedido = fechapedido;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(LocalDate fechapedido) {
        this.fechapedido = fechapedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
