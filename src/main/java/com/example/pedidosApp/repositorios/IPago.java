package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPago extends JpaRepository<Pago,Integer> {
}
