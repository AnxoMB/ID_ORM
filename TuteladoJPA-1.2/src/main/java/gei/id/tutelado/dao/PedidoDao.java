package gei.id.tutelado.dao;

import gei.id.tutelado.configuracion.Configuracion;
import gei.id.tutelado.model.Pedido;
import gei.id.tutelado.model.Cliente;
import java.util.List;

public interface PedidoDao {
    Pedido recuperaPorId(Long id);              // MO4.1
    Pedido almacena(Pedido pedido);             // MO4.2
    void elimina(Pedido pedido);                // MO4.3
    Pedido modifica(Pedido pedido);             // MO4.4
    List<Pedido> recuperaPedidosPorCliente(Cliente cliente); // MO4.6.a

    void setup(Configuracion config);

    long cuentaPedidos(); // MO4.6.d
}
