import javax.swing.*;
import java.sql.*;


public class Main {

    Conexion conexionBD = new Conexion();

    public boolean userExists(int id) throws SQLException {
        Connection conexion = conexionBD.conectar();
        String sql = "SELECT COUNT(*) FROM tb_usuarios WHERE id_usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        boolean exists = rs.getInt(1) > 0;
        rs.close();
        stmt.close();
        conexion.close();
        return exists;
    }

    public void Create (){
        try {
            int id;
            String name, lastName;
            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Usuario: "));
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "⚠ El ID no puede ser negativo.");
                return;
            } else if (userExists(id)) {
                    JOptionPane.showMessageDialog(null, "⚠ El ID ya está registrado.");
                    return;
            }
            name = JOptionPane.showInputDialog("Ingrese el nombre del Usuario: ");
            lastName = JOptionPane.showInputDialog("Ingrese el apellido del Usuario: ");

            Connection conexion = conexionBD.conectar();

            String sql = "INSERT INTO tb_usuarios (id_usuario, nombre, apellido) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, lastName);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "✅ Usuario creado exitosamente.");
            stmt.close();
            conexion.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al crear usuario: " + e.getMessage());
        }

    }

    public void Read() {
        try {
            Connection conexion = conexionBD.conectar();
            String sql = "SELECT * FROM tb_usuarios ORDER BY id_usuario ASC";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            StringBuilder listaUsuarios = new StringBuilder();
            boolean hayUsuarios = false;

            while (rs.next()) {
                hayUsuarios = true;
                listaUsuarios.append("ID: ").append(rs.getInt("id_usuario"))
                        .append(" | Nombre: ").append(rs.getString("nombre"))
                        .append(" | Apellido: ").append(rs.getString("apellido"))
                        .append("\n");
            }

            if (hayUsuarios) {
                JOptionPane.showMessageDialog(null, "📋 Lista de Usuarios:\n\n" + listaUsuarios.toString());
            } else {
                JOptionPane.showMessageDialog(null, "📋 Lista vacia");
            }

            rs.close();
            stmt.close();
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al leer usuarios: " + e.getMessage());
        }
    }

    public void Update() {
        Connection conexion = null;
        PreparedStatement stmt = null;
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a actualizar: "));
            if (!userExists(id) || id < 0) {
                JOptionPane.showMessageDialog(null, "⚠ No se encontró un usuario con ese ID.");
                return;
            }

            conexion = conexionBD.conectar();
            menuUpdate(id, conexion);

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar usuario: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void menuUpdate(int id, Connection conexion) throws SQLException {
        int option;
        boolean exit = false;
        String name, sql;
        PreparedStatement stmt = null;

        while (!exit) {
            option = Integer.parseInt(JOptionPane.showInputDialog(""" 
            Ingrese una opcion que desea actualizar:

            1. Cambiar nombre del usuario
            2. Cambiar apellido del usuario
            3. Salir
        """));

            switch (option) {
                case 1:
                    name = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                    sql = "UPDATE tb_usuarios SET nombre = ? WHERE id_usuario = ?";
                    stmt = conexion.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "✅ Usuario actualizado correctamente.");
                    exit = true;
                    break;

                case 2:
                    name = JOptionPane.showInputDialog("Ingrese el nuevo apellido: ");
                    sql = "UPDATE tb_usuarios SET apellido = ? WHERE id_usuario = ?";
                    stmt = conexion.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "✅ Usuario actualizado correctamente.");
                    exit = true;
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }
        }

        if (stmt != null) stmt.close();
    }

    public void Delete() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar: "));

            Connection conexion = conexionBD.conectar();
            String sql = "DELETE FROM tb_usuarios WHERE id_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "✅ Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "⚠ No se encontró un usuario con ese ID.");
            }

            stmt.close();
            conexion.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar usuario: " + e.getMessage());
        }
    }

    public void Menu(){
        int option;
        boolean exit = false;
        while(!exit){
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                Ingrese una opcion:
                
                1. Crear Usuario
                2. Leer Usuarios
                3. Actualizar Usuario
                4. Eliminar Usuario
                5. Salir
                """));

            switch (option) {
                case 1 -> Create();
                case 2 -> Read();
                case 3 -> Update();
                case 4 -> Delete();
                case 5 -> exit = true;
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }

    public static void main(String[] args) {
        new Main().Menu();
    }
}