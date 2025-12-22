package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;

public class UserCredentialsApi {

    public static void main(String[] args) {
        CredencialUsuario credencial1 = new CredencialUsuario(null, false, "hash", "salt", LocalDateTime.now(), false);
        Usuario usuario1 = new Usuario(null, "Nacho", "ignaciosalazar986@gmail.com", true, LocalDateTime.now(), credencial1);
    }

}
