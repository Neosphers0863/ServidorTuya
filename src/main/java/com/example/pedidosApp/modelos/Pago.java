package com.example.pedidosApp.modelos;

import com.example.pedidosApp.ayudas.enums.PagoEstadoEnum;
import com.example.pedidosApp.ayudas.enums.PagoMetodoEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pago_tabla")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id;
    @Column(name = "fechaPago", nullable = false, updatable = false)
    private LocalDate fechaPago;
    @Enumerated(EnumType.STRING)
    @Column(name = "metododepago", nullable = false)
    private PagoMetodoEnum metododepago;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private PagoEstadoEnum estado;

    @OneToMany(mappedBy = "pago")
    @JsonManagedReference (value = "pedido-pago")
    private List<Pedido> pedido;

    public Pago() {
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

    public PagoMetodoEnum getMetododepago() {
        return metododepago;
    }

    public void setMetododepago(PagoMetodoEnum metododepago) {
        this.metododepago = metododepago;
    }

    public PagoEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(PagoEstadoEnum estado) {
        this.estado = estado;
    }
}
