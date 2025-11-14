package app.gui.ventanas;

import app.gui.controller.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController {

	

	
	@FXML
	private MenuBar menuBar;
	@FXML
	private BorderPane panel;

	@FXML
	void cambiarColor(MouseEvent event) {
		// Suponiendo que tienes una instancia de MenuBar llamada menuBar
		menuBar.setOnMouseEntered(e -> {
			menuBar.setStyle("-fx-background-color: green;");
		});

		menuBar.setOnMouseExited(e -> {
			menuBar.setStyle("-fx-background-color: transparent;");
		});

		for (Menu menu : menuBar.getMenus()) {
			for (MenuItem item : menu.getItems()) {
				item.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
					item.setStyle("-fx-background-color: green;");
				});

				item.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
					item.setStyle("-fx-background-color: transparent;");
				});
			}
		}

	}

	@FXML
	void irACrear(ActionEvent event) {
		Parent vista = cargarVista(FXML_CREAR);
		panel.setCenter(vista);
		
	}

	@FXML
	void crearCamarero(ActionEvent event) {
		Parent vista = cargarVista(FXML_CAMARERO);
		panel.setCenter(vista);
	}

	@FXML
	void creaHorario(ActionEvent event) {
		Parent vista = cargarVista(FXML_HORARIO);
		panel.setCenter(vista);
	}
    @FXML
    void cerrarSesion(ActionEvent event) {
cambiarVista(FXML_LOGIN);
    }

    @FXML
    void salir(ActionEvent event) {
System.exit(0);
    }
    @FXML
    void irAConsulta(ActionEvent event) {
cambiarVista(FXML_CONSULTAR);
    }


}
