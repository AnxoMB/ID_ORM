import org.junit.*;

@RunWith(JUnit4.class)
public class TestLazyLoading {
    private static PedidoDao pedidoDao;

    @BeforeClass
    public static void init() {
        pedidoDao = new PedidoDaoJPA();
    }

    @Test
    public void testLazyLoadingListaProductos() {
        // Código para probar la inicialización de una colección LAZY
    }
}
