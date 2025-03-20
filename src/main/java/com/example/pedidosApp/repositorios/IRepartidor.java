package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepartidor extends JpaRepository<Repartidor,Integer> {
}
