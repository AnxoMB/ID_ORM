package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ClienteDaoJPA implements ClienteDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config.get("EMF");
    }

    @Override
    public Cliente recuperaPorEmail(String email) { // MO4.1
        Cliente cliente = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                    .setParameter("email", email).getSingleResult();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return cliente;
    }

    @Override
    public Cliente almacena(Cliente cliente) { // MO4.2
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return cliente;
    }

    @Override
    public void elimina(Cliente cliente) { // MO4.3
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Cliente clienteTmp = em.find(Cliente.class, cliente.getId());
            em.remove(clienteTmp);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public Cliente modifica(Cliente cliente) { // MO4.4
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> recuperaClientesConPedidos() { // MO4.6.a
        List<Cliente> clientes = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            clientes = em.createQuery("SELECT c FROM Cliente c JOIN c.historialPedidos p", Cliente.class).getResultList();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return clientes;
    }

    @Override
    public List<Cliente> recuperaClientesSinPedidos() { // MO4.6.b
        List<Cliente> clientes = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            clientes = em.createQuery("SELECT c FROM Cliente c LEFT JOIN c.historialPedidos p WHERE p IS NULL", Cliente.class).getResultList();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return clientes;
    }
}
