package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.IRepartidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepartidorServicio {

    @Autowired
    IRepartidor repositorio;
}
