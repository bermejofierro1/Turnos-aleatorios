package app.gui.ventanas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import app.gui.controller.AppController;
import app.gui.modelo.Camarero;
import app.gui.modelo.Horario;
import app.gui.services.HorariosService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HorarioController extends AppController{

	private Horario horario;

	@FXML
	private TableColumn<Horario, List<String>> columnLM;

	@FXML
	private TableColumn<Horario, List<String>> columnLT;
	@FXML
	private TableColumn<Horario, List<String>> columnMM;
	@FXML
	private TableColumn<Horario, List<String>> columnMT;
	@FXML
	private TableColumn<Horario, List<String>> columnXM;
	@FXML
	private TableColumn<Horario, List<String>> columnXT;
	@FXML
	private TableColumn<Horario, List<String>> columnJM;
	@FXML
	private TableColumn<Horario, List<String>> columnJT;
	@FXML
	private TableColumn<Horario, List<String>> columnVM;
	@FXML
	private TableColumn<Horario, List<String>> columnVT;
	@FXML
	private TableColumn<Horario, List<String>> columnSM;
	@FXML
	private TableColumn<Horario, List<String>> columnST;
	@FXML
	private TableColumn<Horario, List<String>> columnDM;
	@FXML
	private TableColumn<Horario, List<String>> columnDT;

	private ObservableList<Horario> datos;

	private HorariosService service;

	@FXML
	private Button btnCrear;
	@FXML
	private TableView<Horario> tabla;


	@FXML
	public void initialize() {

		PropertyValueFactory<Horario, List<String>> factoryValueNombre = new PropertyValueFactory<>("LM");
		PropertyValueFactory<Horario, List<String>> factoryValueCategoria = new PropertyValueFactory<>("LT");
		PropertyValueFactory<Horario, List<String>> factoryValueLink = new PropertyValueFactory<>("MM");
		PropertyValueFactory<Horario, List<String>> MT = new PropertyValueFactory<>("MT");
		PropertyValueFactory<Horario, List<String>> XM = new PropertyValueFactory<>("XM");
		PropertyValueFactory<Horario, List<String>> XT = new PropertyValueFactory<>("XT");
		PropertyValueFactory<Horario, List<String>> JM = new PropertyValueFactory<>("JM");
		PropertyValueFactory<Horario, List<String>> JT = new PropertyValueFactory<>("JT");
		PropertyValueFactory<Horario, List<String>> VM = new PropertyValueFactory<>("VM");
		PropertyValueFactory<Horario, List<String>> VT = new PropertyValueFactory<>("VT");
		PropertyValueFactory<Horario, List<String>> SM = new PropertyValueFactory<>("SM");
		PropertyValueFactory<Horario, List<String>> ST = new PropertyValueFactory<>("ST");
		PropertyValueFactory<Horario, List<String>> DM = new PropertyValueFactory<>("DM");
		PropertyValueFactory<Horario, List<String>> DT = new PropertyValueFactory<>("DT");

		horario = new Horario();

		columnLM.setCellValueFactory(factoryValueNombre);
		columnLT.setCellValueFactory(factoryValueCategoria);
		columnMM.setCellValueFactory(factoryValueLink);
		columnMT.setCellValueFactory(MT);
		columnXM.setCellValueFactory(XM);

		columnXT.setCellValueFactory(XT);
		columnJM.setCellValueFactory(JM);
		columnJT.setCellValueFactory(JT);
		columnVM.setCellValueFactory(VM);
		columnVT.setCellValueFactory(VT);
		columnSM.setCellValueFactory(SM);
		columnST.setCellValueFactory(ST);
		columnDM.setCellValueFactory(DM);
		columnDT.setCellValueFactory(DT);

		service = new HorariosService();

		datos = FXCollections.observableArrayList();
		tabla.setItems(datos);
		// Establecer el tamaño de la fila y la altura de la tabla para mostrar solo una
		// fila
		tabla.setFixedCellSize(30); // Establece el tamaño de la fila, ajusta este valor según sea necesario
		tabla.prefHeightProperty().bind(tabla.fixedCellSizeProperty().multiply(10));
		
		
	}

	@FXML
	void crearHorario(ActionEvent event) {
		crearDisponibilidadFinal();
		
	}

	public void crearDisponibilidadFinal() {
		//Horario horario = new Horario();
		// Map<String, String> mapaDefinitivo = new HashMap<>();
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				// Obtener el mapa de camareros por día
				Map<String, Set<String>> camarerosPorDia = camareroDisponiblePorDia(disponibilidadDeCadaCamarero());


	            // Limpiar los datos actuales de la tabla
	            datos.clear();
	            // Crear una nueva instancia de Horario
                Horario horario = new Horario();
	            // Convertir el mapa a una lista de objetos Horario y agregarlos a la tabla
	            for (Entry<String, Set<String>> entry : camarerosPorDia.entrySet()) {
	                String dia = entry.getKey();
	                Set<String> camareros = entry.getValue();
	                
	               
	                
	                // Asignar la lista de camareros a la propiedad correspondiente del Horario
	                switch (dia) {
	                    case "LM":
	                        horario.setLM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "LT":
	                        horario.setLT(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "MM":
	                        horario.setMM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "MT":
	                        horario.setMT(FXCollections.observableArrayList(camareros));;
	                        break;
	                    case "XM":
	                        horario.setXM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "XT":
	                        horario.setXT(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "JM":
	                        horario.setJM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "JT":
	                        horario.setJT(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "VM":
	                        horario.setVM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "VT":
	                        horario.setVT(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "SM":
	                        horario.setSM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "ST":
	                        horario.setST(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "DM":
	                        horario.setDM(FXCollections.observableArrayList(camareros));
	                        break;
	                    case "DT":
	                        horario.setDT(FXCollections.observableArrayList(camareros));
	                        break;
	                    
	                    // Asignar a las demás propiedades del Horario si es necesario
	                }
	                
	                // Agregar el horario a la lista de datos
	                datos.add(horario);
	            }
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				tabla.setEffect(null);
				// datos.setAll(horarios);
				updateProgress(100, 100);
			}

			@Override
			protected void failed() {
				super.failed();
				tabla.setEffect(null);
				datos.clear();
				mostrarError("No hay registros en la bbdd con ese filtro, por favor seleccione usuario");
				updateProgress(100, 100);
			}

		};
		new Thread(task).start();

	}

	public Boolean comprobarSiEstaDisponible(Map<String, Boolean> disponibilidad, String diaSemana) {

		Set<String> keys = disponibilidad.keySet();
		for (String string : keys) {
			if (string.equals(diaSemana)) {
				if (disponibilidad.get(string) == true) {
					return true;
				} else {
					return false;
				}
			}
		}
		return null;

	}

	public List<String> disponibilidadFinal(Camarero camarero) {
//		Map<String, Boolean> disponibilidadDeCamarero = camarero.getDisponibilidad();
//		List<String> diasDisponibles = new ArrayList<>();
//		// Recorrer el Map y mostrar las claves donde el valor sea true
//		for (Map.Entry<String, Boolean> entry : disponibilidadDeCamarero.entrySet()) {
//			if (entry.getValue()) {
//				System.out.println(entry.getKey());
//				diasDisponibles.add(entry.getKey());
//			}
//		}
//		return diasDisponibles;
		
		 Map<String, Boolean> disponibilidadDeCamarero = camarero.getDisponibilidad();
	        Set<String> diasDisponibles = new HashSet<>(); // Usar un conjunto para evitar duplicados
	        // Recorrer el Map y agregar las claves donde el valor sea true al conjunto
	        for (Map.Entry<String, Boolean> entry : disponibilidadDeCamarero.entrySet()) {
	            if (entry.getValue()) {
	                diasDisponibles.add(entry.getKey());
	            }
	        }
	        return new ArrayList<>(diasDisponibles); // Devol
	}

	public Map<Camarero, Set<String>> disponibilidadDeCadaCamarero() {
//		Map<Camarero, List<String>> devuelve = new HashMap<>();
//		List<Camarero> camareros = service.consultarCamareros();
//		for (Camarero camarero : camareros) {
//			List<String> listaString = disponibilidadFinal(camarero);
//			System.out.println(listaString);
//			devuelve.put(camarero, listaString);
//		}
//		return devuelve;
		
		Map<Camarero, Set<String>> devuelve = new HashMap<>();
        List<Camarero> camareros = service.consultarCamareros();
        for (Camarero camarero : camareros) {
            Set<String> conjuntoDias = new HashSet<>(disponibilidadFinal(camarero)); // Obtener días sin duplicados
            System.out.println("Días disponibles para " + camarero.getNombre() + ": " + conjuntoDias);
            devuelve.put(camarero, conjuntoDias);
        }
        return devuelve;

	}
	

	public Map<String, Set<String>> camareroDisponiblePorDia(Map<Camarero, Set<String>> disponibilidad) {
//
//		Map<String, List<String>> camarerosPorDia = new HashMap<>();
//
//		for (Map.Entry<Camarero, List<String>> entry : disponibilidad.entrySet()) {
//			Camarero camarero = entry.getKey();
//			List<String> diasDisponibles = entry.getValue();
//			System.out.println(diasDisponibles);
//			// Iterar sobre los días disponibles para el camarero
//			for (String dia : diasDisponibles) {
//				// Verificar si el día ya está en el mapa
//				if (!camarerosPorDia.containsKey(dia)) {
//					camarerosPorDia.put(dia, new ArrayList<>());
//				}
//				//System.out.println(dia);
//				// Agregar el camarero a la lista correspondiente al día
//				camarerosPorDia.get(dia).add(camarero.getNombre());
//			}
//		}
//
//		return camarerosPorDia;

		  Map<String, Set<String>> camarerosPorDia = new HashMap<>(); // Usar un mapa de conjuntos para evitar duplicados

	        for (Map.Entry<Camarero, Set<String>> entry : disponibilidad.entrySet()) {
	            Camarero camarero = entry.getKey();
	            Set<String> diasDisponibles = entry.getValue();
	            // Iterar sobre los días disponibles para el camarero
	            for (String dia : diasDisponibles) {
	            	System.out.println(dia);
	                // Verificar si el día ya está en el mapa
	                if (!camarerosPorDia.containsKey(dia)) {
	                    camarerosPorDia.put(dia, new HashSet<>());
	                }
	                // Agregar el camarero al conjunto correspondiente al día
	                camarerosPorDia.get(dia).add(camarero.getNombre());
	            }
	        }

	        return camarerosPorDia;
	}

	@FXML
	void seleccionar(MouseEvent event) {

		horario = tabla.getSelectionModel().getSelectedItem();
		
		putUserDataObject("horario",horario);
		System.out.println(horario);
		cambiarVista(FXML_MOSTRAR);
	}
}
