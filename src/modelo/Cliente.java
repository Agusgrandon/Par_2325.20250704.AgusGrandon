package modelo;
import java.util.List;

/**
 *
 * @author agus
 */
public class Cliente {
    private String nombre;
    private String email;
    private String contraseña;
    private List<Entrada> listaEntradas;

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
