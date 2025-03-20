package com.example.pedidosApp.repositorios;

import com.example.pedidosApp.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducto extends JpaRepository<Producto,Integer> {
}
