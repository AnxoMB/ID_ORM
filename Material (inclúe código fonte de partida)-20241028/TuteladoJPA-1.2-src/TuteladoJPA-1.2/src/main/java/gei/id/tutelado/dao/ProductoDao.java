package gei.id.tutelado.dao;

import gei.id.tutelado.model.Producto;
import java.util.List;

public interface ProductoDao {
    Producto recuperaPorNombre(String nombreProducto); // MO4.1
    Producto almacena(Producto producto);              // MO4.2
    void elimina(Producto producto);                   // MO4.3
    Producto modifica(Producto producto);              // MO4.4
    List<Producto> productosPorCategoria(String categoria); // MO4.6.c
    double promedioPrecio(); // MO4.6.d
}
