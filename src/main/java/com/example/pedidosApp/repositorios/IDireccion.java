package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccion extends JpaRepository<Direccion,Integer> {
}
