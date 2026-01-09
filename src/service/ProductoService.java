package service;

import dao.GenericDAO;
import entities.Producto;
import java.util.List;

public class ProductoService implements GenericService<Producto> {

    private final GenericDAO<Producto> productoDAO;

    public ProductoService(GenericDAO<Producto> productoDAO) {
        this.productoDAO = productoDAO;
    }

    @Override
    public void save(Producto entity) throws Exception {
        if (entity.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no peude ser un número negativo");
        }
        if (entity.getArticulo() == null || entity.getArticulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El artículo no puede estar vacío");
        }
        if (entity.getCodigo() < 0) {
            throw new IllegalArgumentException("El código es requerido");
        }
        productoDAO.crear(entity);
    }

    @Override
    public Producto findById(int id) throws Exception {
        return productoDAO.leer(id);
    }

    @Override
    public List findAll() throws Exception {
        return productoDAO.leerTodos();
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Producto entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
