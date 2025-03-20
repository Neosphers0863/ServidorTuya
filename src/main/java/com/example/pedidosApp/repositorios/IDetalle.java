package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalle extends JpaRepository<Detalle,Integer> {
}
