package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Detalle;
import com.example.pedidosApp.repositorios.IDetalle;
import com.example.pedidosApp.repositorios.IDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServicio {

    @Autowired
    IDetalle repositorio;
}
