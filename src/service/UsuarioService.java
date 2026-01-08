package service;

import dao.GenericDAO;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService implements GenericService<Usuario> {

    private final GenericDAO<Usuario> uDAO;

    public UsuarioService(GenericDAO<Usuario> uDAO) {
        this.uDAO = uDAO;
    }

    @Override
    public void save(Usuario entity) throws Exception {
        uDAO.crear(entity);
    }

    @Override
    public Usuario findById(int id) throws Exception {
        return uDAO.leer(id);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return uDAO.leerTodos();
    }

    @Override
    public void update(Usuario entity) throws Exception {
        uDAO.actualizar(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        uDAO.eliminar(id);
    }

}
