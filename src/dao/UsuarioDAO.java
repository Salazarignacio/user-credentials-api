package dao;

import config.ConnectionDB;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class UsuarioDAO implements GenericDAO<Usuario> {

    @Override
    public void crear(Usuario entity) throws Exception {
        String sql = "INSERT INTO USUARIO (ID, ELIMINADO, HASH_PASSWORD, SALT, ULTIMO_CAMBIO, REQUIRE_RESET) VALUES (?,?,?,?,?,?)";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, entity.getId());
            stmt.setBoolean(2, entity.getEliminado());
            stmt.setString(3, entity.getUserName());
            stmt.setString(4, entity.getEmail());
            stmt.setBoolean(5, entity.getActivo());
            stmt.setTimestamp(6, Timestamp.valueOf(entity.getFechaRegistro()));
            stmt.setLong(7, entity.getCredencialId());
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
