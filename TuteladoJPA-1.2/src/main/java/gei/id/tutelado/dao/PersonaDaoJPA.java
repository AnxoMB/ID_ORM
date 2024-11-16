package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Persona;
import gei.id.tutelado.model.Cliente;//Añadido este import

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonaDaoJPA implements PersonaDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void setup(Configuracion config) {
        this.emf = (EntityManagerFactory) config.get("EMF");
    }

    @Override
    public Persona recuperaPorNif(String nif) { // MO4.1
        Persona persona = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            persona = em.createQuery("SELECT p FROM Persona p WHERE p.nif = :nif", Persona.class)
                    .setParameter("nif", nif).getSingleResult();
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return persona;
    }

    @Override
    public Persona almacena(Persona persona) { // MO4.2
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return persona;
    }

    @Override
    public void elimina(Persona persona) { // MO4.3
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Persona personaTmp = em.find(Persona.class, persona.getId());
            em.remove(personaTmp);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
    }

    @Override
    public Persona modifica(Persona persona) { // MO4.4
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            persona = em.merge(persona);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return persona;
    }

    @Override   //Los pedidos son cosas de clientes no personas
    public Persona inicializaPedidosLazy(Persona persona) { // MO4.5
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            persona = em.merge(persona);
            ((Cliente)persona).getHistorialPedidos().size(); // Inicializa propiedad LAZY
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) em.close();
        }
        return persona;
    }
}
