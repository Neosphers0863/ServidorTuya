package com.example.pedidosApp.modelos;

import com.example.pedidosApp.ayudas.enums.PedidoEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "pedido_tabla")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;
    @Column(name = "fechapedido", nullable = false, updatable = false)
    private LocalDate fechapedido;
    @Column(name = "total", precision = 10, scale = 2, unique = true, nullable = false)
    private double total;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private PedidoEnum estado;

    public Pedido() {
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

    public PedidoEnum getEstado() {
        return estado;
    }

    public void setEstado(PedidoEnum estado) {
        this.estado = estado;
    }
}
