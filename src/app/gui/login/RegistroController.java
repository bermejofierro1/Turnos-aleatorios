package app.gui.login;


import app.gui.controller.AppController;
import app.gui.modelo.Usuario;
import app.gui.services.HorariosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController extends AppController{

	   @FXML
	    private Button btnRegistro;

	    @FXML
	    private TextField txtCorreo;

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private PasswordField txtPass;

	    @FXML
	    private PasswordField txtPassword;

	    @FXML
	    private Button btnVolver;

	    @FXML
	    void irALogin(ActionEvent event) {

	    	Usuario u= new Usuario();
	    	HorariosService service= new HorariosService();
	    	
	    	
	    	if(txtCorreo.getText().isEmpty()||txtNombre.getText().isEmpty()||txtPass.getText().isEmpty()||txtPassword.getText().isEmpty()||txtPass.getText().equals(txtPass.getText())) {
	    		
	    	
	    	
	    	u.setNombre(txtNombre.getText());
	    	u.setCorreo(txtCorreo.getText());
	    	u.setContraseña(txtPassword.getText());
	    	service.insertarUsuario(u);
	    	
	    	}
	    	else {
	    		mostrarError("Las contraseñas deben ser iguales y no debe de haber ningun campo vacido");
	    	}
	    	
	    	
	    	
	    }
	    @FXML
	    void irAlPrincipio(ActionEvent event) {
	cambiarVista(FXML_LOGIN);
	    }
	   
}
