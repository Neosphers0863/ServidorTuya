package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrega extends JpaRepository<Entrega,Integer> {
}
