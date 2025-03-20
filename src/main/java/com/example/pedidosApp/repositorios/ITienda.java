package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITienda extends JpaRepository<Tienda,Integer> {
}
