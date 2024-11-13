import org.junit.*;

@RunWith(JUnit4.class)
public class TestEagerLoading {
    private static ClienteDao clienteDao;

    @BeforeClass
    public static void init() {
        clienteDao = new ClienteDaoJPA();
    }

    @Test
    public void testEagerLoadingHistorialPedidos() {
        // Código para probar la carga EAGER
    }
}
