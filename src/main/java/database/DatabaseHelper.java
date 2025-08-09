package database;

import model.Gasto;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:gastos.db";

    static {
        crearTabla();
    }

    public static void crearTabla() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS gastos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "descripcion TEXT NOT NULL, " +
                    "monto REAL NOT NULL, " +
                    "fecha TEXT NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creando tabla: " + e.getMessage());
        }
    }

    public static void insertarGasto(Gasto gasto) throws SQLException {
        String sql = "INSERT INTO gastos (descripcion, monto, fecha) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gasto.getDescripcion());
            pstmt.setDouble(2, gasto.getMonto());
            pstmt.setString(3, gasto.getFecha());
            pstmt.executeUpdate();
        }
    }

    public static List<Gasto> obtenerGastos() {
        List<Gasto> lista = new ArrayList<>();
        String sql = "SELECT id, descripcion, monto, fecha FROM gastos";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Gasto(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getString("fecha")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener gastos: " + e.getMessage());
        }
        return lista;
    }

    public static void eliminarGasto(int id) {
        String sql = "DELETE FROM gastos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar gasto: " + e.getMessage());
        }
    }

    public static double obtenerTotalGastos() {
        String sql = "SELECT SUM(monto) FROM gastos";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Error al obtener total de gastos: " + e.getMessage());
        }
        return 0.0;
    }
}

