import org.junit.*;

@RunWith(JUnit4.class)
public class TestConsultasJPQL {
    private static PedidoDao pedidoDao;

    @BeforeClass
    public static void init() {
        pedidoDao = new PedidoDaoJPA();
    }

    @Test
    public void testInnerJoinConsulta() {
        // Código para probar la consulta JPQL con INNER JOIN
    }

    @Test
    public void testOuterJoinConsulta() {
        // Código para probar la consulta JPQL con OUTER JOIN
    }

    @Test
    public void testSubconsulta() {
        // Código para probar la consulta JPQL con subconsulta
    }

    @Test
    public void testConsultaAgregacion() {
        // Código para probar la consulta JPQL con agregación (COUNT, AVG, etc.)
    }
}

