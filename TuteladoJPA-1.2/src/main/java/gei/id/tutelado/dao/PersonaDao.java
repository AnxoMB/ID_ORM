package gei.id.tutelado.dao;

import gei.id.tutelado.model.Persona;

public interface PersonaDao {
    Persona recuperaPorNif(String nif); // MO4.1
    Persona almacena(Persona persona);  // MO4.2
    void elimina(Persona persona);      // MO4.3
    Persona modifica(Persona persona);  // MO4.4
    Persona inicializaPedidosLazy(Persona persona); // MO4.5
}
