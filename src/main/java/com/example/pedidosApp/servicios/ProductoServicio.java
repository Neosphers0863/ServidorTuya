package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    IProducto repositorio;
}
