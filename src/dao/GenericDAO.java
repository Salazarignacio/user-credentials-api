package dao;

public interface GenericDAO<T> {

    void crear(T entity) throws Exception;

    void leer(Integer id) throws Exception;

    void leerTodos() throws Exception;

    void actualizar(T entity) throws Exception;

    void eliminar(Integer id) throws Exception;

}
