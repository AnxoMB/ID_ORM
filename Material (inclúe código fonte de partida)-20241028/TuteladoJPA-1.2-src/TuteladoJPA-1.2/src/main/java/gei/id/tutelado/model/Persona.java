package gei.id.tutelado.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.STRING)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "persona_generator")
    @TableGenerator(name = "persona_generator", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nif;

    // Constructor
    public Persona() {}

    public Persona(String nif) {
        this.nif = nif;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    // Implementación de métodos equals y hashCode usando nif
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nif.equals(persona.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }
}
