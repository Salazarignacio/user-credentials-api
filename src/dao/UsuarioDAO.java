package dao;

import config.ConnectionDB;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;

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
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                Long idGenerado = rs.getLong(1);
                entity.setId(idGenerado);
            }
        }
    }

    @Override
    public void leer(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void leerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Usuario entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
