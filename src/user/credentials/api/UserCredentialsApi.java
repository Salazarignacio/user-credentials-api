package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;
import dao.CredencialUsuarioDAO;
import dao.UsuarioDAO;

public class UserCredentialsApi {

    public static void main(String[] args) throws Exception {
        CredencialUsuario nuevaCredencial = new CredencialUsuario(false, "hash", "salt", LocalDateTime.now(), false);

        Usuario nuevoUsuario = new Usuario("Nuevo usuario", "nuevousuario@gmail.com", true, LocalDateTime.now(), nuevaCredencial);

        CredencialUsuarioDAO credencialDAO = new CredencialUsuarioDAO();
        credencialDAO.crear(nuevaCredencial);
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.crear(nuevoUsuario);
    }

}
