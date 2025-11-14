package app.gui.login;


import app.gui.controller.AppController;
import app.gui.modelo.Usuario;
import app.gui.services.HorariosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AppController{


    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnRegistro;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUsuario;

    @FXML
    void irPaginaInicio(ActionEvent event) {
    	HorariosService service= new HorariosService();
    	
    	Usuario u= new Usuario();
    	u.setNombre(txtUsuario.getText());
    	
    	Usuario alta=service.consultarUsuario(txtUsuario.getText());
    	
    	if(alta!=null) {
    		putUserDataObject("usuarioConectado",alta);
    		cambiarVista(FXML_BIENVENIDA);
    	}
    	
    	
    	
    }
    @FXML
    void irARegistro(ActionEvent event) {
cambiarVista(FXML_REGISTRO);
    }
}
