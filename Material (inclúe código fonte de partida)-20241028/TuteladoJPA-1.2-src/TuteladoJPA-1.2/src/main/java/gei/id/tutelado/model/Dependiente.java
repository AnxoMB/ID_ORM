package gei.id.tutelado.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("DEPENDIENTE")
public class Dependiente extends Persona {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Date fechaContratacion;

    // Constructor sin parámetros
    public Dependiente() {}

    // Constructor con parámetros
    public Dependiente(String nombre, Date fechaContratacion) {
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

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
