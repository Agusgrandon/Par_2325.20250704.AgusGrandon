package controlador;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;
import modelo.Sala;

/**
 *
 * @author agus
 */
public class CompraView {
    public CompraView(Stage stage, Cine cine, Sala sala, Cliente cliente) {
        Label lbl = new Label("Sala: " + sala.getNumero());
        Label lbl2 = new Label();
        lbl2.setText(sala.mostrarButacas());
        Label lblComprar = new Label("Ingrese la butaca: ");
        Label textfila = new Label("Fila:");
        TextField fila = new TextField();
        Label textcolumna = new Label("Columna:");
        TextField columna = new TextField();
        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");
        Label resultado = new Label();
        
        btnAceptar.setOnAction(e -> {
            try {
                int f = Integer.parseInt(fila.getText());
                int c = Integer.parseInt(columna.getText());
                if (sala.getButaca(f - 1, c - 1).estaOcupada()){
                    resultado.setText("La butaca ya esta ocupada, podes elejir otra");
                }else{
                    sala.ocuparButaca(f - 1, c - 1);
                    Entrada entrada = new Entrada(cliente, sala, sala.getButaca(f - 1, c - 1));
                    cine.agregarEntrada(entrada);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION, "¡Compra realizada con exito!");
                    alerta.showAndWait();
                    lbl2.setText(sala.mostrarButacas());
                }
                
            } catch (NumberFormatException | IndexOutOfBoundsException nfe) {
                resultado.setText("Butaca invalida, ingresa un dato correcto");
            }
        });
        
        btnCancelar.setOnAction( e -> {
            MenuView menu = new MenuView(stage, cine, cliente);
            stage.setScene(new Scene(menu));
        });
        
        getChildren().addAll(lbl, lbl2, lblComprar,textfila, fila, textcolumna, columna, btnAceptar, btnCancelar, resultado);
    } 

}
