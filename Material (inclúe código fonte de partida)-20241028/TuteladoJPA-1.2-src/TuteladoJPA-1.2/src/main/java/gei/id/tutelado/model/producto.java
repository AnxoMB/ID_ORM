import javax.persistence.*;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "producto_generator")
    @TableGenerator(name = "producto_generator", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombreProducto;

    @Column(nullable = false)
    private double precio;

    @ElementCollection
    private Set<String> categorias;

    // Getters y setters
}