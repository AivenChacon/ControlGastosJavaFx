package AppController;

import database.DatabaseHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Gasto;

import java.time.LocalDate;

public class Controller {

    @FXML private TextField txtDescripcion;
    @FXML private TextField txtMonto;
    @FXML private TableView<Gasto> tablaGastos;
    @FXML private TableColumn<Gasto, String> colDescripcion;
    @FXML private TableColumn<Gasto, Double> colMonto;
    @FXML private TableColumn<Gasto, String> colFecha;

    private ObservableList<Gasto> listaGastos;

    @FXML
    public void initialize() {
        colDescripcion.setCellValueFactory(data -> data.getValue().descripcionProperty());
        colMonto.setCellValueFactory(data -> data.getValue().montoProperty().asObject());
        colFecha.setCellValueFactory(data -> data.getValue().fechaProperty());

        listaGastos = FXCollections.observableArrayList(DatabaseHelper.obtenerGastos());
        tablaGastos.setItems(listaGastos);
    }

    @FXML
    public void agregarGasto() {
        String descripcion = txtDescripcion.getText();
        String montoStr = txtMonto.getText();

        if (descripcion.isEmpty() || montoStr.isEmpty()) {
            mostrarAlerta("Error", "Debes llenar todos los campos");
            return;
        }

        try {
            double monto = Double.parseDouble(montoStr);
            if (monto <= 0) throw new NumberFormatException();

            String fecha = LocalDate.now().toString();
            Gasto gasto = new Gasto(descripcion, monto, fecha);
            DatabaseHelper.insertarGasto(gasto);
            listaGastos.setAll(DatabaseHelper.obtenerGastos());

            txtDescripcion.clear();
            txtMonto.clear();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Monto inválido. Ingresa un número positivo.");
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo agregar el gasto.");
        }
    }

    @FXML
    public void eliminarGastoSeleccionado() {
        Gasto gasto = tablaGastos.getSelectionModel().getSelectedItem();
        if (gasto != null) {
            DatabaseHelper.eliminarGasto(gasto.getId());
            listaGastos.setAll(DatabaseHelper.obtenerGastos());
        } else {
            mostrarAlerta("Error", "Selecciona un gasto para eliminar.");
        }
    }

    @FXML
    public void mostrarTotalGastos() {
        double total = DatabaseHelper.obtenerTotalGastos();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Total de Gastos");
        alert.setHeaderText(null);
        alert.setContentText("El total de gastos es: $" + total);
        alert.showAndWait();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
