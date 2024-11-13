package gei.id.tutelado.model;

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<String> categorias) {
        this.categorias = categorias;
    }
}