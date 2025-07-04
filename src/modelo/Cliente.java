package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agus
 */
public class Cliente implements Serializable{
    private String nombre;
    private String email;
    private String contraseña;
    private List<Entrada> listaEntradas;

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.listaEntradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }
    
    public boolean validarContraseña(String contraseña){
        return this.contraseña.equals(contraseña);
    }
    
    public void agregarEntrada(Entrada entrada){
        listaEntradas.add(entrada);
    } 
}
