package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;
import dao.CredencialUsuarioDAO;
import dao.UsuarioDAO;

public class UserCredentialsApi {

    public static void main(String[] args) throws Exception {
        CredencialUsuario nuevaCredencial = new CredencialUsuario(false, "hash", "salt", LocalDateTime.now(), false);

        // Usuario nuevoUsuario = new Usuario("Nuevo usuario4", "nuevousuario4@gmail.com", true, LocalDateTime.now(), nuevaCredencial);
        CredencialUsuarioDAO credencialDAO = new CredencialUsuarioDAO();
        credencialDAO.crear(nuevaCredencial);
        nuevaCredencial.setHashPassword("Editado");

        //  UsuarioDAO usuario = new UsuarioDAO();
        //  usuario.crear(nuevoUsuario);
        //  credencialDAO.leer(1);
        //  credencialDAO.leerTodos();
        //  credencialDAO.eliminar(9);
        //  nuevaCredencial.setHashPassword("testeando hash");
          credencialDAO.actualizar(nuevaCredencial);
    }

}
