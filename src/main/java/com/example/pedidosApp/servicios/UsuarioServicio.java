package com.example.pedidosApp.servicios;

import com.example.pedidosApp.repositorios.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuario repositorio;

}
