package com.example.pedidosApp.modelos;

import com.example.pedidosApp.ayudas.enums.PedidoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "total", unique = true, nullable = false)
    private double total;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private PedidoEnum estado;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference (value = "pedido-usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_pago", referencedColumnName = "id_pago")
    @JsonBackReference (value = "pedido-pago")
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id_tienda")
    @JsonBackReference (value = "tienda-pedido")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "fk_detalle", referencedColumnName = "id_detalle")
    @JsonBackReference (value = "pedido-detalle")
    private Detalle detalle;

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
