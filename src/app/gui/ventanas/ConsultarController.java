package app.gui.ventanas;

import java.util.List;
import java.util.Map;

import app.gui.controller.AppController;
import app.gui.modelo.Camarero;
import app.gui.modelo.Horario;
import app.gui.services.HorariosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ConsultarController extends AppController{

	
	@FXML
	private ComboBox<String> cboxUsuarios;

	@FXML
	private ListView<Boolean> dm;

	@FXML
	private ListView<Boolean> dt;

	@FXML
	private ListView<Boolean> jm;

	@FXML
	private ListView<Boolean> jt;

	@FXML
	private ListView<Boolean> lt;

	@FXML
	private ListView<Boolean> mm;

	@FXML
	private ListView<Boolean> mt;

	@FXML
	private ListView<Boolean> sm;

	@FXML
	private ListView<Boolean> st;

	@FXML
	private ListView<Boolean> vm;

	@FXML
	private ListView<Boolean> vt;

	@FXML
	private ListView<Boolean> xm;

	@FXML
	private ListView<Boolean> xt;

	private HorariosService service;

	@FXML
	void initialize() {
		service = new HorariosService();
		List<String> usuarios = service.consultarNombreDeUsuarios();
		for (String string : usuarios) {
			cboxUsuarios.getItems().add(string);
		}
		// Configurar las celdas personalizadas para mostrar emoticonos
		lt.setCellFactory(new EmoticonCellFactory());
		mm.setCellFactory(new EmoticonCellFactory());
		xm.setCellFactory(new EmoticonCellFactory());
		xt.setCellFactory(new EmoticonCellFactory());
		jm.setCellFactory(new EmoticonCellFactory());
		jt.setCellFactory(new EmoticonCellFactory());
		vm.setCellFactory(new EmoticonCellFactory());
		vt.setCellFactory(new EmoticonCellFactory());
		sm.setCellFactory(new EmoticonCellFactory());
		st.setCellFactory(new EmoticonCellFactory());
		dm.setCellFactory(new EmoticonCellFactory());
		dt.setCellFactory(new EmoticonCellFactory());
		mt.setCellFactory(new EmoticonCellFactory());

	}

	@FXML
	void generar(ActionEvent event) {
		limpiarListView();
		Horario horario = new Horario();
		String nombreCamarero = cboxUsuarios.getValue();
		Camarero camarero = service.consultarCamarero(nombreCamarero);
		Map<String, Boolean> disponibilidad = camarero.getDisponibilidad();
		Boolean lma = disponibilidad.get("LM");
		Boolean lta = disponibilidad.get("LT");
		Boolean mma = disponibilidad.get("MM");
		Boolean mta = disponibilidad.get("MT");
		Boolean xma = disponibilidad.get("XM");
		Boolean xta = disponibilidad.get("XT");
		Boolean jma = disponibilidad.get("JM");
		Boolean jta = disponibilidad.get("JT");
		Boolean vma = disponibilidad.get("VM");
		Boolean vta = disponibilidad.get("VT");
		Boolean sma = disponibilidad.get("SM");
		Boolean sta = disponibilidad.get("ST");
		Boolean dma = disponibilidad.get("DM");
		Boolean dta = disponibilidad.get("DT");

		lt.getItems().add(lta);
		mm.getItems().add(mma);
		mt.getItems().add(mta);
		xm.getItems().add(xma);
		xt.getItems().add(xta);
		jm.getItems().add(jma);
		jt.getItems().add(jta);
		vm.getItems().add(vma);
		vt.getItems().add(vta);
		sm.getItems().add(sma);
		st.getItems().add(sta);
		dm.getItems().add(dma);
		dt.getItems().add(dta);

	}

	public void limpiarListView() {
		lt.getItems().clear();
		mm.getItems().clear();
		mt.getItems().clear();
		xm.getItems().clear();
		xt.getItems().clear();
		jm.getItems().clear();
		jt.getItems().clear();
		vm.getItems().clear();
		vt.getItems().clear();
		sm.getItems().clear();
		st.getItems().clear();
		dm.getItems().clear();
		dt.getItems().clear();

	}

	@FXML
	void volver(ActionEvent event) {
		cambiarVista(FXML_BIENVENIDA);
	}

}
