package dao;

import entities.Producto;
import java.util.List;
import java.sql.Connection;
import config.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO implements GenericDAO<Producto> {

    @Override
    public void crear(Producto entity) throws Exception {
        System.out.println("Recibido desde DAO");
        String sql = "INSERT INTO Producto (articulo, categoria, precio, stock, codigo) VALUES (?,?,?,?,?)";
        try (Connection conn = config.ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, entity.getArticulo());
            stmt.setString(2, entity.getCategoria());
            stmt.setDouble(3, entity.getPrecio());
            stmt.setInt(4, entity.getStock());
            stmt.setInt(5, entity.getCodigo());
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas < 1) {
                throw new SQLException("No se pudo crear el usuario");
            }
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                Long idGenerado = rs.getLong(1);
                entity.setId(idGenerado);
            }
            System.out.println(entity);
        }
    }

    @Override
    public Producto leer(Integer id) throws Exception {
        String sql = "SELECT * FROM Producto WHERE ID = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Producto prod = new Producto(rs.getString("articulo"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"), rs.getInt("codigo"));
                prod.setId(rs.getLong(1));
                System.out.println(prod);
                return prod;
            } else {
                throw new SQLException("No se encontro ID");
            }
        }
    }

    @Override
    public ArrayList leerTodos() throws Exception {
        ArrayList<Producto> productos = new ArrayList();
        String sql = "SELECT * FROM Producto";
        try (Connection conn = config.ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto(rs.getString("articulo"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"), rs.getInt("codigo"));
                productos.add(prod);
            }
        }
        System.out.println(productos);
        return productos;
    }

    @Override
    public void actualizar(Producto entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
