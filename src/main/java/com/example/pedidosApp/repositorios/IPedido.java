package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedido extends JpaRepository<Pedido,Integer> {
}
