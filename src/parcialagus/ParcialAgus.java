package parcialagus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Cine;
import persistencia.PersistenciaDatos;
import vista.LoginView;

/**
 *
 * @author agus
 */
public class ParcialAgus extends Application{

 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        Cine cine = PersistenciaDatos.cargar();
        
        LoginView loguearse = new LoginView(stage, cine);
        stage.setScene(new Scene(loguearse));
        stage.setTitle("Cines Hoyts");
        stage.setWidth(400);
        stage.setHeight(400);
        //guardo el archivo
        stage.setOnCloseRequest(eh -> PersistenciaDatos.guardar(cine));
        stage.show();
    }
    
}
