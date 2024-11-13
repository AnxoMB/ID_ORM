package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Pedido;
import gei.id.tutelado.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PedidoDaoJPA implements PedidoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config;
    }
    @Override
    public long cuentaPedidos(){
        return -3;
    }
    @Override
    public List<Pedido> recuperaPedidosPorCliente(Cliente cliente){
        return null;
    }
    @Override
    public Pedido modifica(Pedido pedido){
        return null;
    }
    @Override
    public void elimina (Pedido pedido){

    }
    @Override
    public Pedido almacena (Pedido pedido){
        return null;
    }
    @Override
    public Pedido recuperaPorId(Long id){
        return null;
    }
}