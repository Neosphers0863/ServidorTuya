package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.IEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaServicio {

    @Autowired
    IEntrega repositorio;
}
