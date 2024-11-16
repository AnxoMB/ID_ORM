package gei.id.tutelado.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("DEPENDIENTE")
public class Dependiente extends Persona {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaContratacion;

    // Constructor sin parámetros
    public Dependiente() {}

    // Constructor con parámetros
    public Dependiente(String nombre, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
