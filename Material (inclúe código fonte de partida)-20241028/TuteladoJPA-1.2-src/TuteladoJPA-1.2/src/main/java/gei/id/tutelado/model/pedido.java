import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pedido_generator")
    @TableGenerator(name = "pedido_generator", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> listaProductos;

    // Atributo adicional para las cantidades de cada producto en el pedido
    @ElementCollection
    private List<Long> listaCantidades;

    // Getters y setters
}