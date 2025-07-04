
package vista;
import javafx.scene.layout.VBox;

/**
 *
 * @author agus
 */
public class RegistroView extends VBox{
    public RegistrarView(Stage stage, Cine cine) {
            Label lblUser = new Label("Usuario");
            TextField campoUsuario = new TextField();
            Label lblNombre = new Label("Nombre");
            TextField campoNombre = new TextField();
            Label lblPw = new Label("Contraseña");
            PasswordField campoContraseña = new PasswordField();
            Label lblEmail = new Label("Correo");
            TextField campoEmail = new TextField();
            Button btnRegistrarse = new Button("Registrarse");
            Button btnSalir = new Button("Salir");
    
            btnRegistrarse.setOnAction( e -> {
                String usuario = campoUsuario.getText();
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String contraseña = campoContraseña.getText();
                Cliente cliente = new Cliente(nombre, email, contraseña);
                if (cine.getClientes().containsKey(usuario)){
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION,"El usuario ya existe, ingresa otro");
                    alerta.showAndWait();
                }else{
                    cine.registrarCliente(cliente, usuario);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION,"Registro exitoso");
                    alerta.showAndWait();
                    LoginView login = new LoginView(stage, cine);
                    stage.setScene(new Scene(login));
                }
            });
            
            btnSalir.setOnAction( e -> {
                LoginView login = new LoginView(stage, cine);
                stage.setScene(new Scene(login));
            });

            getChildren().addAll(lblUser, campoUsuario, lblNombre, campoNombre, lblEmail, campoEmail, lblPw, campoContraseña, btnRegistrarse, btnSalir);
    }
}
