package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends JpaRepository<Usuario,Integer> {
    // ACA DENTRO DEL REPO VAN LAS CONSULTAS PERSONALIZADAS
}
