import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Persona {
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> historialPedidos = new HashSet<>(); // Configurado como LAZY por defecto

    // Métodos de conveniencia para la relación bidireccional con Pedido
    public void addPedido(Pedido pedido) {
        historialPedidos.add(pedido);
        pedido.setCliente(this);
    }

    public void removePedido(Pedido pedido) {
        historialPedidos.remove(pedido);
        pedido.setCliente(null);
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(Set<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }
}
