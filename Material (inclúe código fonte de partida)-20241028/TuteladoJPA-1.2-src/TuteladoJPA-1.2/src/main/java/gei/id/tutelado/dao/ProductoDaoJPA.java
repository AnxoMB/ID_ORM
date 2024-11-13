package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductoDaoJPA implements ProductoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config.get("EMF");
    }

    @Override
    public Producto recuperaPorNombre(String nombreProducto) { // MO4.1
        Producto producto = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            producto = em.createQuery("SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto", Producto.class)
                    .setParameter("nombreProducto", nombreProducto).getSingleResult();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public Producto almacena(Producto producto) { // MO4.2
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public void elimina(Producto producto) { // MO4.3
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Producto productoTmp = em.find(Producto.class, producto.getId());
            em.remove(productoTmp);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public Producto modifica(Producto producto) { // MO4.4
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            producto = em.merge(producto);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return producto;
    }

    @Override
    public List<Producto> productosPorCategoria(String categoria) { // MO4.6.c
        List<Producto> productos = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            productos = em.createQuery("SELECT p FROM Producto p JOIN p.categorias c WHERE c = :categoria", Producto.class)
                    .setParameter("categoria", categoria).getResultList();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return productos;
    }

    @Override
    public double promedioPrecio() { // MO4.6.d
        double promedio = 0.0;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            promedio = em.createQuery("SELECT AVG(p.precio) FROM Producto p", Double.class).getSingleResult();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return promedio;
    }
}
