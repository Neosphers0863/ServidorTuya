package com.example.pedidosApp.modelos;

import com.example.pedidosApp.ayudas.enums.EntregaEnum;
import com.example.pedidosApp.ayudas.enums.PagoEstadoEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "entrega_tabla")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer id;
    @Column(name = "fechaEntrega", nullable = false, updatable = false)
    private LocalDate fechaEntrega;
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoEntrega", nullable = false)
    private EntregaEnum estadoEntrega;

    @ManyToOne
    @JoinColumn(name = "fk_repartidor",referencedColumnName = "id_repartidor")
    @JsonManagedReference
    private Repartidor repartidores;

    public Entrega() {
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

    public EntregaEnum getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(EntregaEnum estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }
}
