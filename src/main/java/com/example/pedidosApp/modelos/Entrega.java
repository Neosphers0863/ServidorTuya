package com.example.pedidosApp.modelos;

import java.time.LocalDate;

public class Entrega {

    private Integer id;
    private LocalDate fechaEntrega;

    public Entrega() {
    }

    public Entrega(Integer id, LocalDate fechaEntrega) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
