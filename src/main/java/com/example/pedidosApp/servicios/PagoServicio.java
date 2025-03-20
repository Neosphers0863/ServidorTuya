package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.IPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PagoServicio {

    @Autowired
    IPago repositorio;
}
