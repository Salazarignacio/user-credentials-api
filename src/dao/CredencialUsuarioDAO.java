package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import config.ConnectionDB;
import entities.CredencialUsuario;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CredencialUsuarioDAO implements GenericDAO<CredencialUsuario> {

    @Override
    public void crear(CredencialUsuario entity) throws SQLException {
        String sql = "INSERT INTO credencial_usuario (eliminado, hash_password, salt, ultimo_cambio, require_reset) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setBoolean(1, entity.getEliminado());
            stmt.setString(2, entity.getHashPassword());
            stmt.setString(3, entity.getSalt());
            stmt.setTimestamp(4, Timestamp.valueOf(entity.getUltimoCambio()));
            stmt.setBoolean(5, entity.getRequireReset());
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                throw new SQLException("No se pudo crear el usuario");
            }

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                Long idGenerado = rs.getLong(1);
                entity.setId(idGenerado);
            }
        }
    }

    @Override
    public CredencialUsuario leer(Integer id) throws SQLException {
        String sql = "SELECT * FROM credencial_usuario WHERE ID = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                CredencialUsuario credencial = new CredencialUsuario(rs.getBoolean("eliminado"), rs.getString("hash_password"), rs.getString("salt"), rs.getTimestamp("ultimo_cambio").toLocalDateTime(), rs.getBoolean("require_reset"));
                credencial.setId(rs.getLong("id")); // o 1
                return credencial;
            } else {
                throw new SQLException("No se encontro ID");
            }
        }
    }

    @Override
    public ArrayList<CredencialUsuario> leerTodos() throws SQLException {
        String sql = "SELECT * FROM credencial_usuario";
        ArrayList<CredencialUsuario> credenciales = new ArrayList();
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CredencialUsuario credencial = new CredencialUsuario(rs.getBoolean("eliminado"), rs.getString("hash_password"), rs.getString("salt"), rs.getTimestamp("ultimo_cambio").toLocalDateTime(), rs.getBoolean("require_reset"));
                credencial.setId(rs.getLong("id"));
                credenciales.add(credencial);
            }
            return credenciales;
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM credencial_usuario WHERE ID = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new SQLException("No se encontro ID");
            } else {
                System.out.println("ID eliminado correctamente");
            }
        }
    }

    @Override
    public void actualizar(CredencialUsuario entity) throws Exception {
        String sql = "UPDATE credencial_usuario "
                + "SET eliminado = ?, hash_password = ?, salt = ?, ultimo_cambio = ?, require_reset = ? "
                + "WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setBoolean(1, entity.getEliminado());
            stmt.setString(2, entity.getHashPassword());
            stmt.setString(3, entity.getSalt());
            stmt.setTimestamp(4, Timestamp.valueOf(entity.getUltimoCambio()));
            stmt.setBoolean(5, entity.getRequireReset());
            stmt.setLong(6, entity.getId());
            System.out.println(entity.getId());

            int filaAfectada = stmt.executeUpdate();

            if (filaAfectada == 0) {
                throw new Exception("No se pudo actualizar la credencial. ID no encontrado");
            }
        }
    }

}
