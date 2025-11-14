package app.gui.ventanas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.gui.controller.AppController;
import app.gui.modelo.Camarero;
import app.gui.modelo.Usuario;
import app.gui.services.HorariosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class CrearController extends AppController{
	
	@FXML
	private CheckBox DM;

	@FXML
	private CheckBox DT;

	@FXML
	private CheckBox JM;

	@FXML
	private CheckBox JT;

	@FXML
	private CheckBox LM;

	@FXML
	private CheckBox LT;

	@FXML
	private CheckBox MM;

	@FXML
	private CheckBox MT;

	@FXML
	private CheckBox SM;

	@FXML
	private CheckBox ST;

	@FXML
	private CheckBox VM;

	@FXML
	private CheckBox VT;

	@FXML
	private CheckBox XM;

	@FXML
	private CheckBox XT;

	@FXML
	private ComboBox<String> cboxUsuario;

	private HorariosService service;
	@FXML
	private Button btnBorrar;

	@FXML
	private Button btnBorrarTodo;
	@FXML
	private CheckBox chckboxFinde;

	@FXML
	public void initialize() {
		service = new HorariosService();
		List<String> usuarios = service.consultarNombreDeUsuarios();
		for (String string : usuarios) {
			cboxUsuario.getItems().add(string);
		}

	}

	@FXML
	void crearDisponibilidad(ActionEvent event) {
		Camarero c = service.consultarCamarero(cboxUsuario.getValue());

		Usuario u = (Usuario) getUserDataObject("usuarioConectado");
		if (cboxUsuario.getValue().equalsIgnoreCase(u.getNombre()) || u.getNombre().equalsIgnoreCase("cuki")) {
			Map<String, Boolean> horario = new HashMap<>();
			if (LM.isSelected()) {

				horario.put("LM", true);
			} else {
				horario.put("LM", false);
			}
			if (LT.isSelected()) {
				horario.put("LT", true);
			} else {
				horario.put("LT", false);
			}
			if (MM.isSelected()) {
				horario.put("MM", true);
			} else {
				horario.put("MM", false);
			}
			if (MT.isSelected()) {
				horario.put("MT", true);
			} else {
				horario.put("MT", false);
			}
			if (XM.isSelected()) {
				horario.put("XM", true);
			} else {
				horario.put("XM", false);
			}
			if (XT.isSelected()) {
				horario.put("XT", true);
			} else {
				horario.put("XT", false);
			}
			if (JM.isSelected()) {
				horario.put("JM", true);
			} else {
				horario.put("JM", false);
			}
			if (JT.isSelected()) {
				horario.put("JT", true);
			} else {
				horario.put("JT", false);
			}
			if (VM.isSelected()) {
				horario.put("VM", true);
			} else {
				horario.put("VM", false);
			}
			if (VT.isSelected()) {
				horario.put("VT", true);
			} else {
				horario.put("VT", false);
			}
			if (SM.isSelected()) {
				horario.put("SM", true);
			} else {
				horario.put("SM", false);
			}
			if (ST.isSelected()) {
				horario.put("ST", true);
			} else {
				horario.put("ST", false);
			}
			if (DM.isSelected()) {
				horario.put("DM", true);
			} else {
				horario.put("DM", false);
			}
			if (DT.isSelected()) {
				horario.put("DT", true);
			} else {
				horario.put("DT", false);
			}

//		Set<String>keys=horario.keySet();
//		for (String string : keys) {
//			System.out.println("clave: "+string);
//			System.out.println("valo: "+horario.get(string));
//		}

			service.actualizarCamarero(c, horario);
			putUserDataObject("horario", horario);
		} else {

			mostrarError("Solo el administrador puede modificar los demás usuarios");

		}
	}

	@FXML
	void borrar(ActionEvent event) {

		Usuario u = (Usuario) getUserDataObject("usuarioConectado");
		if (cboxUsuario.getValue().equalsIgnoreCase(u.getNombre()) || u.getNombre().equalsIgnoreCase("cuki")) {
			Camarero c = service.consultarCamarero(cboxUsuario.getValue());
			service.borrarDisponibilidadUnCamarero(c);

		} else {
			mostrarError("Solo el administrador puede borrar los turnos de los demás");

		}
	}

	@FXML
	void borrarTodo(ActionEvent event) {

		Usuario u = (Usuario) getUserDataObject("usuarioConectado");
		if (cboxUsuario.getValue().equalsIgnoreCase(u.getNombre()) || u.getNombre().equalsIgnoreCase("cuki")) {

			service.borrarDisponibilidadDeTodosLosCamareros();

		} else {

			mostrarError("Solo el administrador puede borrar todos los turnos");
		}

	}

	@FXML
	void seleccionarFinde(ActionEvent event) {

		if (chckboxFinde.isSelected()) {
			VT.setSelected(true);
			SM.setSelected(true);
			ST.setSelected(true);
			DM.setSelected(true);
			DT.setSelected(true);
			putUserDataObject("trabajaFindeCuki", true);
		}
	}

}
