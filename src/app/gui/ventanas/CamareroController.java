package app.gui.ventanas;

import app.gui.controller.AppController;
import app.gui.modelo.Camarero;
import app.gui.services.HorariosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CamareroController extends AppController {

	@FXML
	private Button btnCrear;

	@FXML
	private TextField txtNombre;
	  @FXML
	    private Button btnVolver;

	@FXML
	void crearCamarero(ActionEvent event) {
		Camarero camarero = new Camarero();
		HorariosService service= new HorariosService();
		camarero.setNombre(txtNombre.getText());
		if(txtNombre.getText().isEmpty()||service.consultarCamarero(txtNombre.getText())!=null) {
			mostrarError("Debe indicar un nombre válido o que no exista ya");
		}
		service.insertarCamarero(camarero);
	}

    @FXML
    void irAInicio(ActionEvent event) {
cambiarVista(FXML_BIENVENIDA);
    }
}
