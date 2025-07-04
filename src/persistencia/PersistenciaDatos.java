package persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Sala;

public class PersistenciaDatos {
private static final String ARCHIVO = "clientes.ser";
    
    public static void guardar(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        } catch (IOException ioe) {            
            System.out.println("Error guardando cine: " + ioe.getMessage());
        }
    }
    
    public static Cine cargar(){
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            HashMap<String, Cliente> clientes = new HashMap<>();
            List<Sala> salas = new ArrayList<>();
            salas.add(new Sala(1, "Mulan"));
            salas.add(new Sala(2, "Shrek"));
            salas.add(new Sala(3, "Lilo y stich"));
            List<Entrada> entradas = new ArrayList<>();
            Cine cine = new Cine(salas, entradas, clientes);
            return cine;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
           return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error cargando el cine: " + ioe.getMessage());
            HashMap<String, Cliente> clientes = new HashMap<>();
            List<Sala> salas = new ArrayList<>();
            salas.add(new Sala(1, "Mulan"));
            salas.add(new Sala(2, "Shrek"));
            salas.add(new Sala(3, "Lilo y stich"));
            List<Entrada> entradas = new ArrayList<>();
            Cine cine = new Cine(salas, entradas, clientes);
            return cine;
        }
    }
    
}
