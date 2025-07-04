package modelo;
import java.io.Serializable;

/**
 *
 * @author agus
 */
public class Entrada implements Serializable{
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Tu entrada: " + sala.toString() + butaca.toString();
    }
    
    
}
