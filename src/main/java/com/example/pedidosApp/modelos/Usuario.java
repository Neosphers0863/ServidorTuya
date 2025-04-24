package com.example.pedidosApp.modelos;

import com.example.pedidosApp.ayudas.enums.UsuarioEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario_tabla")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nombre", length = 100, unique = true, nullable = false)
    private String nombre;
    @Column(name = "correoEletronico", length = 150, unique = true, nullable = false)
    private String correoEletronico;
    @Column(name = "contrasena", length = 254, unique = true, nullable = false)
    private String contrasena;
    @Column(name = "telefono", length = 20, unique = true, nullable = true)
    private String telefono;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private UsuarioEnum tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference (value = "direccion-usuario")
    private List<Direccion> direccion;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference (value = "pedido-usuario")
    private List<Pedido> pedido;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoEletronico, String contrasena, String telefono, UsuarioEnum tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correoEletronico = correoEletronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoEletronico() {
        return correoEletronico;
    }

    public void setCorreoEletronico(String correoEletronico) {
        this.correoEletronico = correoEletronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


}
