package com.example.pedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.sound.sampled.Line;
import java.util.List;

@Entity
@Table(name = "direccion_tabla")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer id;
    @Column(name = "calle", length = 254, unique = true, nullable = false)
    private String calle;
    @Column(name = "ciudad", length = 100, unique = true, nullable = false)
    private String ciudad;
    @Column(name = "codigoPostal", length = 20, unique = true, nullable = true)
    private String codigoPostal;
    @Column(name = "pais", length = 50, unique = true, nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference (value = "direccion-usuario")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(Integer id, String calle, String ciudad, String codigoPostal, String pais) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
