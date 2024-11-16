package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Pedido;
import gei.id.tutelado.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PedidoDaoJPA implements PedidoDao {

    private EntityManagerFactory emf;

    @Override
    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config.get("EMF");
    }

    @Override
    public long cuentaPedidos() {
        EntityManager em = null;
        long count = 0;
        try {
            em = emf.createEntityManager();
            count = em.createQuery("SELECT COUNT(p) FROM Pedido p", Long.class)
                    .getSingleResult();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return count;
    }

    @Override
    public List<Pedido> recuperaPedidosPorCliente(Cliente cliente) {
        EntityManager em = null;
        List<Pedido> pedidos = null;
        try {
            em = emf.createEntityManager();
            pedidos = em.createQuery("SELECT p FROM Pedido p WHERE p.cliente = :cliente", Pedido.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return pedidos;
    }

    @Override
    public Pedido modifica(Pedido pedido) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            pedido = em.merge(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return pedido;
    }

    @Override
    public void elimina(Pedido pedido) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Pedido pedidoTmp = em.find(Pedido.class, pedido.getId());
            if (pedidoTmp != null) {
                em.remove(pedidoTmp);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    @Override
    public Pedido almacena(Pedido pedido) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return pedido;
    }

    @Override
    public Pedido recuperaPorId(Long id) {
        EntityManager em = null;
        Pedido pedido = null;
        try {
            em = emf.createEntityManager();
            pedido = em.find(Pedido.class, id);
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return pedido;
    }
}
