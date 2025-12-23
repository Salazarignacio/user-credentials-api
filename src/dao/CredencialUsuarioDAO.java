package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import config.ConnectionDB;
import entities.CredencialUsuario;
import java.sql.Timestamp;

public class CredencialUsuarioDAO implements GenericDAO<CredencialUsuario> {

    @Override
    public void crear(CredencialUsuario entity) throws Exception {
        String sql = "INSERT INTO credencial_usuario (eliminado, hash_password, salt, ultimo_cambio, require_reset) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            //stmt.setLong(1, entity.getId());
            stmt.setBoolean(1, entity.getEliminado());
            stmt.setString(2, entity.getHashPassword());
            stmt.setString(3, entity.getSalt());
            stmt.setTimestamp(4, Timestamp.valueOf(entity.getUltimoCambio()));
            stmt.setBoolean(5, entity.getRequireReset());
            int filasAfectadas = stmt.executeUpdate();
            System.out.println(filasAfectadas);
        }
    }

    @Override
    public void leer(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void leerTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(CredencialUsuario entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
