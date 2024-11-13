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
        this.emf = (EntityManagerFactory) config
