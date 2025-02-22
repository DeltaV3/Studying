import javax.swing.*;
import java.sql.*;

public class Conexion {
    public Connection conectar() {
        Connection conexion = null;
        try {
            // Establecer conexión
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bd_prueba",
                    "postgres",
                    ""
            );
            System.out.println("✅ Conexión exitosa.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}
