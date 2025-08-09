import database.DatabaseHelper;
import model.Gasto;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class test {

    static void prepararBD() {
        DatabaseHelper.crearTabla();
    }

    @Test
    void testInsertarGasto() throws SQLException {
        Gasto gasto = new Gasto("JUnit Test", 200.50, LocalDate.now().toString());
        DatabaseHelper.insertarGasto(gasto);

        List<Gasto> gastos = DatabaseHelper.obtenerGastos();
        assertTrue(gastos.stream().anyMatch(g -> g.getDescripcion().equals("JUnit Test")),
                "El gasto insertado debe estar en la base de datos");
    }

    @Test
    void testObtenerGastos() {
        List<Gasto> gastos = DatabaseHelper.obtenerGastos();
        assertNotNull(gastos, "La lista de gastos no debe ser nula");
        assertFalse(gastos.isEmpty(), "Debe haber al menos un gasto en la base de datos");
    }

    @Test
    void testObtenerTotalGastos() {
        double total = DatabaseHelper.obtenerTotalGastos();
        assertTrue(total > 0, "El total de gastos debe ser mayor que 0");
    }

    @Test
    void testEliminarGasto() throws SQLException {
        // Insertamos un gasto temporal
        Gasto gasto = new Gasto("Temporal", 50.0, LocalDate.now().toString());
        DatabaseHelper.insertarGasto(gasto);

        // Obtenemos su ID
        List<Gasto> gastos = DatabaseHelper.obtenerGastos();
        Gasto ultimo = gastos.get(gastos.size() - 1);

        // Lo eliminamos
        DatabaseHelper.eliminarGasto(ultimo.getId());

        // Verificamos que ya no esté
        List<Gasto> gastosDespues = DatabaseHelper.obtenerGastos();
        assertTrue(gastosDespues.stream().noneMatch(g -> g.getId() == ultimo.getId()),
                "El gasto eliminado no debe aparecer en la base de datos");
    }
}
