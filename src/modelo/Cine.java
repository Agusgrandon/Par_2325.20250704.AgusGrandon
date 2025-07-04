package modelo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author agus
 * Cine: contiene lista de salas y entradas.
 */
public class Cine implements Serializable{
    private List<Sala> salas;
    private List<Entrada> entradas;
    private HashMap<String, Cliente> clientes;

    public Cine(List<Sala> salas, List<Entrada> entradas, HashMap<String, Cliente> clientes) {
        this.salas = salas;
        this.entradas = entradas;
        this.clientes = clientes;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
    
    public void registrarClientes(Cliente cliente, String usuario){
        clientes.put(usuario, cliente);
    }
    
    public void agregarEntrada(Entrada entrada){
        entradas.add(entrada);
        entrada.getCliente().agregarEntrada(entrada);
    }
    
    public String entradasString(Cliente cliente){
        List<Entrada> lista = cliente.getListaEntradas();
        String resultado = "";
        
        if(lista.isEmpty()){
            resultado = "No compraste ninguna entrada";
        } else {
            for(Entrada entrada : lista){
                resultado += entrada.toString() + "\n";
            }
        }
        return resultado;
    }
}
