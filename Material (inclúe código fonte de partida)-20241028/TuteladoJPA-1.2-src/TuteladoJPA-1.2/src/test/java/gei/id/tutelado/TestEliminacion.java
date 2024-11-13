import org.junit.*;

@RunWith(JUnit4.class)
public class TestEliminacion {
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
    public void testEliminacionProducto() {
        // Prueba de eliminación de Producto
    }

    @Test
    public void testEliminacionCliente() {
        // Prueba de eliminación de Cliente
    }

    @Test
    public void testEliminacionPedido() {
        // Prueba de eliminación de Pedido
    }
}
