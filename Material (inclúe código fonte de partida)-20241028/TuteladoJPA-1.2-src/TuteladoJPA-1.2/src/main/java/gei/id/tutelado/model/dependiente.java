import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("DEPENDIENTE")
public class Dependiente extends Persona {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Date fechaContratacion;

    // Getters y setters
}