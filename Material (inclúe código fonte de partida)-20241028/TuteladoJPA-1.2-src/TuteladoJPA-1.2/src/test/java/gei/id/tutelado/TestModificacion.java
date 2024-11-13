import org.junit.*;

@RunWith(JUnit4.class)
public class TestModificacion {
    private static ProductoDao productoDao;
    private static ClienteDao clienteDao;
    private static PedidoDao pedidoDao;

    @BeforeClass
    public static void init() {
        productoDao = new ProductoDaoJPA();
        clienteDao = new ClienteDaoJPA();
        pedidoDao = new PedidoDaoJPA();
    }

    @Test
    public void testModificacionProducto() {
        // Prueba de modificación de Producto
    }

    @Test
    public void testModificacionCliente() {
        // Prueba de modificación de Cliente
    }

    @Test
    public void testModificacionPedido() {
        // Prueba de modificación de Pedido
    }
}
