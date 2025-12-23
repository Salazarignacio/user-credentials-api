package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;
import dao.CredencialUsuarioDAO;

public class UserCredentialsApi {

    public static void main(String[] args) throws Exception {
        CredencialUsuario credencial1 = new CredencialUsuario(null, false, "hash", "salt", LocalDateTime.now(), false);
        CredencialUsuario credencial2 = new CredencialUsuario(null, false, "hash2", "salt2", LocalDateTime.now(), false);
        Usuario usuario1 = new Usuario(null, "Nacho", "ignaciosalazar986@gmail.com", true, LocalDateTime.now(), credencial1);
        CredencialUsuarioDAO credencialDAO = new CredencialUsuarioDAO();
        credencialDAO.crear(credencial2);
    }

}
