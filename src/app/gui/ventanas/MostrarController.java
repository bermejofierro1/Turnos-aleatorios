package app.gui.ventanas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import app.gui.controller.AppController;
import app.gui.modelo.Camarero;
import app.gui.modelo.Horario;
import app.gui.services.HorariosService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MostrarController extends AppController{

	

    @FXML
    private ListView<String> domingoTarde;
    @FXML
    private ListView<String> juevesTarde;
    @FXML
    private ListView<String> lunesTarde;
    @FXML
    private ListView<String> martesTarde;
    @FXML
    private ListView<String> sabadoTarde;
    @FXML
    private ListView<String> viernesTarde;
    @FXML
    private ListView<String> xTarde;
    @FXML
    private Button btnGenerar;
    @FXML
    private ListView<String> listDomingo;
    @FXML
    private ListView<String> listDomingo2;
    @FXML
    private ListView<String> listJueves;
    @FXML
    private ListView<String> listJueves2;
    @FXML
    private ListView<String> listLunes2;
    @FXML
    private ListView<String> listMartes;
    @FXML
    private ListView<String> listMartes2;
    @FXML
    private ListView<String> listMiercoles;
    @FXML
    private ListView<String> listMiercoles2;
    @FXML
    private ListView<String> listSabado;
    @FXML
    private ListView<String> listSabado2;
    @FXML
    private ListView<String> listViernes;
    @FXML
    private ListView<String> listViernes2;
    @FXML
    private ListView<String> listView;

    private Horario horarios;
    private HorariosService service;
    Boolean mostrarCuki;

    @FXML
    public void initialize() {
        horarios = (Horario) getUserDataObject("horario");
        service = new HorariosService();
        mostrarCuki = (Boolean) getUserDataObject("trabajaFindeCuki");
    }

    @FXML
    void generar(ActionEvent event) {
        limpiarList();

        asignarTurnos(listLunes2, horarios.getLT(), 3, true, false);
        asignarTurnos(listMartes, horarios.getMM(), 2, false, true);
        asignarTurnos(listMartes2, horarios.getMT(), 3, true, false);
        asignarTurnos(listMiercoles, horarios.getXM(), 3, true, false);
        asignarTurnos(listMiercoles2, horarios.getXT(), 3, true, false);
        asignarTurnos(listJueves, horarios.getJM(), 3, true, false);
        asignarTurnos(listJueves2, horarios.getJT(), 3, true, false);
        asignarTurnos(listViernes, horarios.getVM(), 4, true, false);
        asignarTurnos(listViernes2, horarios.getVT(), 4, true, false);
        asignarTurnos(listSabado, horarios.getSM(), 4, true, false);
        asignarTurnos(listSabado2, horarios.getST(), 4, true, false);
        asignarTurnos(listDomingo, horarios.getDM(), 4, true, false);
        asignarTurnos(listDomingo2, horarios.getDT(), 4, true, false);

        String camLunes = consultarQuienSeQuedaDeTarde(lunesTarde, listView.getItems(), listLunes2.getItems(), "");
        String camMartes = consultarQuienSeQuedaDeTarde(martesTarde, listMartes.getItems(), listMartes2.getItems(), camLunes);
        String camX = consultarQuienSeQuedaDeTarde(xTarde, listMiercoles.getItems(), listMiercoles2.getItems(), camMartes);
        String camJ = consultarQuienSeQuedaDeTarde(juevesTarde, listJueves.getItems(), listJueves2.getItems(), camX);
        String camV = consultarQuienSeQuedaDeTarde(viernesTarde, listViernes.getItems(), listViernes2.getItems(), camJ);
        String camS = consultarQuienSeQuedaDeTarde(sabadoTarde, listSabado.getItems(), listSabado2.getItems(), camV);
        consultarQuienSeQuedaDeTarde(domingoTarde, listDomingo.getItems(), listDomingo2.getItems(), camS);
    }

    private void limpiarList() {
        listView.getItems().clear();
        listLunes2.getItems().clear();
        listMartes.getItems().clear();
        listMartes2.getItems().clear();
        listMiercoles.getItems().clear();
        listMiercoles2.getItems().clear();
        listJueves.getItems().clear();
        listJueves2.getItems().clear();
        listViernes.getItems().clear();
        listViernes2.getItems().clear();
        listSabado.getItems().clear();
        listSabado2.getItems().clear();
        listDomingo.getItems().clear();
        listDomingo2.getItems().clear();
        lunesTarde.getItems().clear();
        martesTarde.getItems().clear();
        xTarde.getItems().clear();
        juevesTarde.getItems().clear();
        viernesTarde.getItems().clear();
        sabadoTarde.getItems().clear();
        domingoTarde.getItems().clear();
    }

    private void asignarTurnos(ListView<String> turno, List<String> camareros, int cantidadDeseada, boolean incluirMujeres, boolean dobleTurno) {
       
    	if(camareros==null||camareros.isEmpty()) {
    		System.out.println("Sin camarero para este turno");
    		return;
    	}
    	
    	Random random = new Random();
        Map<String, Integer> disponibilidad = consultarDisponibilidadCamareros(camareros);
        List<String> camarerosOrdenados = ordenarCamarerosPorDisponibilidad(disponibilidad);
        Set<String> camarerosSeleccionados = new HashSet<>();
        int mujeresSeleccionadas = 0;

        for (int i = 0; i < cantidadDeseada; i++) {
            if (incluirMujeres && mujeresSeleccionadas < 2) {
                for (String camarero : camarerosOrdenados) {
                    Camarero c = service.consultarCamarero(camarero);
                    if (c.getGenero().equalsIgnoreCase("femenino") && !camarerosSeleccionados.contains(camarero)) {
                        turno.getItems().add(camarero);
                        camarerosSeleccionados.add(camarero);
                        mujeresSeleccionadas++;
                        break;
                    }
                }
            } else {
                String camareroSeleccionado;
                do {
                    int index = random.nextInt(camarerosOrdenados.size());
                    camareroSeleccionado = camarerosOrdenados.get(index);
                } while (camarerosSeleccionados.contains(camareroSeleccionado));
                turno.getItems().add(camareroSeleccionado);
                camarerosSeleccionados.add(camareroSeleccionado);
            }
        }
    }

    private Map<String, Integer> consultarDisponibilidadCamareros(List<String> turno) {
        Map<String, Integer> disponibilidad = new HashMap<>();
        for (String string : turno) {
            Camarero c = service.consultarCamarero(string);
            disponibilidad.put(string, service.numerodeTurnosdeCadaCamarero(c));
        }
        return disponibilidad;
    }

    private List<String> ordenarCamarerosPorDisponibilidad(Map<String, Integer> disponibilidad) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(disponibilidad.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.add(entry.getKey());
        }
        return result;
    }

    private String consultarQuienSeQuedaDeTarde(ListView<String> tarde, ObservableList<String> manana, ObservableList<String> tardeAnterior, String anterior) {
        String camareroSeleccionado = "";
        for (String string : manana) {
            if (!tardeAnterior.contains(string) && !string.equals(anterior)) {
                camareroSeleccionado = string;
                tarde.getItems().add(string);
                break;
            }
        }
        if (camareroSeleccionado.isEmpty() && !anterior.isEmpty()) {
            tarde.getItems().add(anterior);
            camareroSeleccionado = anterior;
        }
        return camareroSeleccionado;
    }
}
