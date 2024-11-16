package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductoDaoJPA implements ProductoDao {

    private EntityManagerFactory emf;

    @Override
    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config.get("EMF");
    }

    @Override
    public Producto recuperaPorNombre(String nombreProducto) {
        EntityManager em = null;
        Producto producto = null;
        try {
            em = emf.createEntityManager();
            producto = em.createQuery("SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto", Producto.class)
                    .setParameter("nombreProducto", nombreProducto)
                    .getSingleResult();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public Producto almacena(Producto producto) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public void elimina(Producto producto) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Producto productoTmp = em.find(Producto.class, producto.getId());
            if (productoTmp != null) {
                em.remove(productoTmp);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
    }

    @Override
    public Producto modifica(Producto producto) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            producto = em.merge(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public List<Producto> productosPorCategoria(String categoria) {
        EntityManager em = null;
        List<Producto> productos = null;
        try {
            em = emf.createEntityManager();
            productos = em.createQuery("SELECT p FROM Producto p JOIN p.categorias c WHERE c = :categoria", Producto.class)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return productos;
    }

    @Override
    public double promedioPrecio() {
        EntityManager em = null;
        double promedio = 0.0;
        try {
            em = emf.createEntityManager();
            promedio = em.createQuery("SELECT AVG(p.precio) FROM Producto p", Double.class)
                    .getSingleResult();
        } finally {
            if (em != null && em.isOpen()) em.close();
        }
        return promedio;
    }
}
