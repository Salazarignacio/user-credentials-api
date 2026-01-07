package service;

import dao.GenericDAO;
import entities.CredencialUsuario;
import java.util.List;

public class CredencialService implements GenericService<CredencialUsuario> {
    
    private final GenericDAO<CredencialUsuario> credencialDAO;
    
    public CredencialService(GenericDAO<CredencialUsuario> credencialDAO) {
        this.credencialDAO = credencialDAO;
    }
    
    @Override
    public void save(CredencialUsuario entity) throws Exception {
        if (entity.getSalt() == null) {
            throw new IllegalArgumentException("Se debe ingresar un email");
        }
        credencialDAO.crear(entity);
    }
    
    @Override
    public CredencialUsuario findById(int id) throws Exception {
        return credencialDAO.leer(id);
    }
    
    @Override
    public List<CredencialUsuario> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void update(CredencialUsuario entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
