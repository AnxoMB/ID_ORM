package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Cliente;
import java.util.List;

public interface ClienteDao {
    Cliente recuperaPorEmail(String email); // MO4.1
    Cliente almacena(Cliente cliente);      // MO4.2
    void elimina(Cliente cliente);          // MO4.3
    Cliente modifica(Cliente cliente);      // MO4.4
    List<Cliente> recuperaClientesConPedidos(); // MO4.6.a
    List<Cliente> recuperaClientesSinPedidos(); // MO4.6.b

    void setup(Configuracion cfg);
}
