package com.example.pedidosApp.modelos;

import java.time.LocalDate;

public class Pago {

    private Integer id;
    private LocalDate fechaPago;

    public Pago() {
    }

    public Pago(Integer id, LocalDate fechaPago) {
        this.id = id;
        this.fechaPago = fechaPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

}
