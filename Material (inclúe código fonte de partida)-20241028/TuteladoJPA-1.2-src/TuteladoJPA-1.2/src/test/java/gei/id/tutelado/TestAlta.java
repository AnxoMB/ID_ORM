import org.junit.*;

@RunWith(JUnit4.class)
public class TestAlta {
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
    public void testAltaProducto() {
        // Prueba de alta de Producto
    }

    @Test
    public void testAltaCliente() {
        // Prueba de alta de Cliente
    }

    @Test
    public void testAltaPedido() {
        // Prueba de alta de Pedido
    }
}

