package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Pedido;
import com.example.pedidosApp.repositorios.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    IPedido repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Pedido guardarPedido(Pedido datosPedido) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosPedido);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Pedido> buscarPedidos() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Pedido buscarPedidoPorId(Integer idPedido) throws Exception{
        try{

            Optional<Pedido> pedidoBuscado=this.repositorio.findById(idPedido);
            if (pedidoBuscado.isPresent()){
                return pedidoBuscado.get();
            }else {
                throw new Exception("El pedido consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Pedido modificarPedido(Integer id, Pedido datosPedido) throws Exception{
        try{

            Optional<Pedido> pedidoBuscado=this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()){
                pedidoBuscado.get().setFechapedido(datosPedido.getFechapedido());
                pedidoBuscado.get().setEstado(datosPedido.getEstado());
                return this.repositorio.save(pedidoBuscado.get());
            }else{
                throw new Exception("Pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarPedido(Integer id) throws Exception{
        try{

            Optional<Pedido> pedidoBuscado=this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
