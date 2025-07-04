package modelo;
import java.io.Serializable;

/**
 *
 * @author agus
 */
public class Butaca implements Serializable{
    private int numero;
    private int fila;
    private boolean estado;

    public Butaca(int numero, int fila, boolean estado) {
        this.numero = numero;
        this.fila = fila;
        this.estado = estado;
    }
    
    public boolean estaOcupada(){
        return estado;
    }
    
    public void SetOcupada(boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Butaca{" + "numero=" + numero + ", fila=" + fila + ", estado=" + estado + '}';
    }
    
    
}
