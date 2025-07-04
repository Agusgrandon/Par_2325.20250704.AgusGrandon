package parcialagus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
       Button btn = new Button("Click");
       StackPane layout = new StackPane(btn);
       Scene scene = new Scene(layout, 300, 400);
       stage.setScene(scene);
       stage.setTitle("JavaFX");
       btn.setOnAction( eh -> {
           //Programacion de la reacción al evento
           System.out.println("Se registro un clic!");
       });
       stage.show();
    }
    
}
