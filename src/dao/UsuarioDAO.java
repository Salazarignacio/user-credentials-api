package dao;

import config.ConnectionDB;
import entities.CredencialUsuario;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UsuarioDAO implements GenericDAO<Usuario> {

    @Override
    public void crear(Usuario entity) throws Exception {
        String sql = "INSERT INTO USUARIO (ELIMINADO, USERNAME, EMAIL, ACTIVO, FECHA_REGISTRO, CREDENCIAL_ID) VALUES (?,?,?,?,?,?)";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setBoolean(1, entity.getEliminado());
            stmt.setString(2, entity.getUserName());
            stmt.setString(3, entity.getEmail());
            stmt.setBoolean(4, entity.getActivo());
            stmt.setTimestamp(5, Timestamp.valueOf(entity.getFechaRegistro()));
            stmt.setLong(6, entity.getCredencialId());
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new Exception("No se pudo crear el usuario");
            }

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                Long idGenerado = rs.getLong(1);
                entity.setId(idGenerado);
            }

            //stmt.executeUpdate();

        }
    }

    @Override
    public Usuario leer(Integer id) throws Exception {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Hay que dar explicaciones de lo que se hizo aca y ver si es viable 
                CredencialUsuario credencial = new CredencialUsuario();
                Usuario usuario = new Usuario(rs.getString("username"), rs.getString("email"), rs.getBoolean("activo"), rs.getTimestamp("fecha_registro").toLocalDateTime(), credencial);
                usuario.setId(rs.getLong("id"));
                usuario.setCredencialId(rs.getLong("credencial_id"));
                return usuario;
            } else {
                throw new SQLException("No se encontro ID");
            }
        }
    }

    @Override
    public ArrayList<Usuario> leerTodos() throws Exception {
        String sql = "SELECT * FROM USUARIO";
        ArrayList<Usuario> usuarios = new ArrayList();
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CredencialUsuario credencial = new CredencialUsuario();
                Usuario usuario = new Usuario(rs.getString("username"), rs.getString("email"), rs.getBoolean("activo"), rs.getTimestamp("fecha_registro").toLocalDateTime(), credencial);
                usuarios.add(usuario);
            }
            return usuarios;
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE ID = ?";
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
    public void actualizar(Usuario entity) throws SQLException {
        String sql = "UPDATE usuario "
                + "SET eliminado = ?, username = ?, email = ?, activo = ?, fecha_registro = ?, credencial_id = ? "
                + "WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, entity.getEliminado());
            stmt.setString(2, entity.getUserName());
            stmt.setString(3, entity.getEmail());
            stmt.setBoolean(4, entity.getActivo());
            stmt.setTimestamp(5, Timestamp.valueOf(entity.getFechaRegistro()));
            stmt.setLong(6, entity.getCredencialId());
            stmt.setLong(7, entity.getId());

            int filaAfectada = stmt.executeUpdate();

            if (filaAfectada == 0) {
                throw new SQLException("No se pudo actualizar la credencial. ID no encontrado");
            }
        }
    }

}
