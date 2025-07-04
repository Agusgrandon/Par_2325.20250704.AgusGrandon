/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;
import modelo.Sala;
import vista.LoginView;


/**
 *
 * @author agus
 */
public class MenuView extends VBox{
    public MenuView(Stage stage, Cine cine, Cliente cliente) {
        Label bienvenida = new Label("Bienvenido al Cine, elija una pelicula");
        Button btnPelicula1 = new Button("Mulan");
        Button btnPelicula2 = new Button("Shrek");
        Button btnPelicula3 = new Button("Lilo y stich");
        Button btnEntradas = new Button("Mis Entradas");
        Button btnSalir = new Button("Salir");
        
        btnPelicula1.setOnAction( e -> {
            Sala sala = cine.getSalas().get(0);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });

        btnPelicula2.setOnAction( e -> {
            Sala sala = cine.getSalas().get(1);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });
        
        btnPelicula3.setOnAction( e -> {
            Sala sala = cine.getSalas().get(2);
            CompraView vista = new CompraView(stage, cine, sala, cliente);
            stage.setScene(new Scene(vista));
        });
        
        btnEntradas.setOnAction( e -> {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, ("Mis entradas: \n " + cine.entradasString(cliente)));
            alerta.showAndWait();
        });
        
        btnSalir.setOnAction( e -> {
            LoginView login = new LoginView(stage, cine);
            stage.setScene(new Scene(login));
        });
        
        getChildren().addAll(bienvenida, btnPelicula1, btnPelicula2, btnPelicula3, btnEntradas, btnSalir);
    }
  
}
