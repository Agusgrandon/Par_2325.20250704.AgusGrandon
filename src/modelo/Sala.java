
package modelo;
import java.io.Serializable;

/**
 *
 * @author agus
 */
public class Sala implements Serializable{
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;

    public Sala(int numero, String pelicula) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[6][4];
        //inicio la matriz
        for( int i = 0; i <10; i++){
            for( int j = 0; j <10; j++){
                butacas[i][j] = new Butaca(i, j, false);
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getPelicula() {
        return pelicula;
    }

    public Butaca getButaca(int fila, int columna){
            return butacas[fila][columna];
    }
    
    public void setPelicula(String pelicula){
        this.pelicula = pelicula;
    }
    
    public String mostrarButacas() {
        String resultado = "";
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                resultado += butacas[i][j].estaOcupada() ? "[x]" : "[ ]";
            }
            resultado += "\n";
        }
        return resultado;
    }
    
    public void ocuparButaca(int fila, int columna){
        butacas[fila][columna].SetOcupada(true);
    }

    @Override
    public String toString() {
        return "Sala{" + "numero=" + numero + ", pelicula=" + pelicula + ", butacas=" + butacas + '}';
    }
    
    
}
