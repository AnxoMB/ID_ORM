package gei.id.tutelado.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pedido_generator")
    @TableGenerator(name = "pedido_generator", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> listaProductos = new ArrayList<>(); // Inicializar lista

    // Atributo adicional para las cantidades de cada producto en el pedido
    @ElementCollection
    private List<Long> listaCantidades = new ArrayList<>(); // Inicializar lista

    // Método para añadir un producto y su cantidad al pedido
    public void addProducto(Producto producto, Long cantidad) {
        if (producto == null || cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("Producto y cantidad deben ser válidos.");
        }
        this.listaProductos.add(producto);
        this.listaCantidades.add(cantidad);
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Long> getListaCantidades() {
        return listaCantidades;
    }

    public void setListaCantidades(List<Long> listaCantidades) {
        this.listaCantidades = listaCantidades;
    }
}
