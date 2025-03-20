package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.ITienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaServicio {

    @Autowired
    ITienda repositorio;

}
