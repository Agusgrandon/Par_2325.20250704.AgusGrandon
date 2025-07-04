
package vista;

import controlador.MenuView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cine;
import modelo.Cliente;

/**
 *
 * @author agus
 */
public class LoginView extends VBox{
    public LoginView(Stage stage, Cine cine) {
            Label lblUser = new Label("Usuario");
            
            TextField campoUsuario = new TextField();
            Label mensaje = new Label();
            
            Button btnIngresar =new Button("Ingresar");
            Label lblPw = new Label("Contraseña");
            
            PasswordField campoContraseña = new PasswordField();
            Button btnRegistrarse = new Button("Registrarse");
            
    
            btnIngresar.setOnAction( e -> {
                String usuario = campoUsuario.getText();
                String contraseña = campoContraseña.getText();
                Cliente cliente = cine.getClientes().get(usuario);
                
                if (cliente != null && cliente.validarContraseña(contraseña)) {
                    MenuView menu = new MenuView(stage, cine, cliente);
                    stage.setScene(new Scene(menu));
                } else {
                    mensaje.setText("Datos incorrectos");
                }
            });
            
            btnRegistrarse.setOnAction( e -> {
               RegistroView registro = new RegistroView(stage, cine); 
               stage.setScene(new Scene(registro));
            });
            

            getChildren().addAll(lblUser, campoUsuario, lblPw, campoContraseña, btnIngresar, mensaje, btnRegistrarse);
    }
}
