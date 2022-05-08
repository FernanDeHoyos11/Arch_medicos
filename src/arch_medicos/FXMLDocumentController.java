/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arch_medicos;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modelo.Archivos;
import modelo.Medicos;

/**
 *
 * @author fernan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private TableView<Medicos> tablaMedicos;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtedad;
    @FXML
    private TextField txttesp;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnModificar;
    @FXML
    private Button bnEliminar;
    @FXML
    private Button btnNuevo;
    ObservableList<Medicos> medicos;
    private int posicionPersonaEnTabla;
    
    @FXML
    private TableColumn Ccodigo;
    @FXML
    private TableColumn Cnombre;
    @FXML
    private TableColumn Ctelefono;
    @FXML
    private TableColumn  Cedad;
    @FXML
    private TableColumn  Cesp;
    private void handleButtonAction(ActionEvent event) {
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // Inicializamos la tabla
        this.inicializarTablaPersonas();

        // Ponemos estos dos botones para que no se puedan seleccionar
        btnModificar.setDisable(true);
        //eliminarBT.setDisable(true);

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Medicos> tablaPersonaSel = tablaMedicos.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);

        // Inicializamos la tabla con algunos datos aleatorios
        for (int i = 0; i < 20; i++) {
            Medicos p1 = new Medicos();
            p1.id.set("112423 " + i);
            p1.nombre.set("Nombre " + i);
            p1.especialisacion.set("Especialisacios " + i);
            p1.edad.set(20 + i);
            p1.telefono.set(31366910+ i);
            medicos.add(p1);
        }
    }
        

    @FXML
    private void Añadir(ActionEvent event) {
        Medicos persona = new Medicos();
        persona.id.set(txtid.getText());
        persona.nombre.set(txtnom.getText());
        persona.telefono.set(Integer.parseInt(txtTel.getText()));
        persona.edad.set(Integer.parseInt(txtedad.getText()));
        persona.especialisacion.set(txttesp.getText());
        
        medicos.add(persona);
    }

    @FXML
    private void modificar(ActionEvent event) {
        
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void nuevo(ActionEvent event) {
        
    }
    
     private void inicializarTablaPersonas() {
        Ccodigo.setCellValueFactory(new PropertyValueFactory<Medicos, String>("Codigo"));
        Cnombre.setCellValueFactory(new PropertyValueFactory<Medicos, String>("Nombre"));
        Ctelefono.setCellValueFactory(new PropertyValueFactory<Medicos, Integer>("Telefono"));
        Cedad.setCellValueFactory(new PropertyValueFactory<Medicos, Integer>("Edad"));
        Cesp.setCellValueFactory(new PropertyValueFactory<Medicos, String>("Especialisacion"));

        medicos = FXCollections.observableArrayList();
        tablaMedicos.setItems(medicos);
    }
    private final ListChangeListener<Medicos> selectorTablaPersonas =
            (ListChangeListener.Change<? extends Medicos> c) -> {
                ponerPersonaSeleccionada();
    };
    
     public Medicos getTablaPersonasSeleccionada() {
        if (tablaMedicos != null) {
            List<Medicos> tabla = tablaMedicos.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Medicos competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
     
    private void ponerPersonaSeleccionada() {
        final Medicos persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = medicos.indexOf(persona);

        if (persona != null) {

            // Pongo los textFields con los datos correspondientes
            txtnom.setText(persona.getNombre());
            txtid.setText(persona.getId());
            txtedad.setText(persona.getEdad().toString());
            txtTel.setText(persona.getTelefono().toString());
            txttesp.setText(persona.getEspecialisacion());

            // Pongo los botones en su estado correspondiente
            btnModificar.setDisable(false);
           // eliminarBT.setDisable(false);
            btnAñadir.setDisable(true);

        }
    }
}
