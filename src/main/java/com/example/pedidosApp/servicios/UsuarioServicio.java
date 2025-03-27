package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Usuario;
import com.example.pedidosApp.repositorios.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuario repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosUsuario);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario) throws Exception{
        try{

            Optional<Usuario> usuarioBuscado=this.repositorio.findById(idUsuario);
            if (usuarioBuscado.isPresent()){
                return usuarioBuscado.get();
            }else {
                throw new Exception("El usuario consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID

    public Usuario modificarUsuario(Integer id, Usuario datosUsurio) throws Exception{
        try{

            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                usuarioBuscado.get().setTelefono(datosUsurio.getTelefono());
                usuarioBuscado.get().setCorreoEletronico(datosUsurio.getCorreoEletronico());
                return this.repositorio.save(usuarioBuscado.get());
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID

    public boolean eliminarUsuario(Integer id) throws Exception{
        try{

            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
