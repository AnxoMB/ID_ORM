import org.junit.*;

@RunWith(JUnit4.class)
public class TestCascade {
    private static ClienteDao clienteDao;
    private static PedidoDao pedidoDao;

    @BeforeClass
    public static void init() {
        clienteDao = new ClienteDaoJPA();
        pedidoDao = new PedidoDaoJPA();
    }

    @Test
    public void testCascadeDeleteClientePedidos() {
        // Código para probar la eliminación en cascada
    }
}
