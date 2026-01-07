package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;
import dao.CredencialUsuarioDAO;
import dao.UsuarioDAO;

public class UserCredentialsApi {

    public static void main(String[] args) throws Exception {
        //  CredencialUsuario nuevaCredencial = new CredencialUsuario(false, "hash", "salt", LocalDateTime.now(), false);
        //  Usuario nuevoUsuario = new Usuario("Nuevo usuario14", "nuevousuario14@gmail.com", true, LocalDateTime.now(), nuevaCredencial);

        //  CredencialUsuarioDAO credencialDAO = new CredencialUsuarioDAO();
        //  credencialDAO.crear(nuevaCredencial);
        //  nuevaCredencial.setHashPassword("Editado");
        //  System.out.println(credencialDAO.leer(1).getId());
        //  System.out.println(credencialDAO.leerTodos());
        //  credencialDAO.eliminar(9);
        //  nuevaCredencial.setHashPassword("testeando hash");
        //  credencialDAO.actualizar(nuevaCredencial);

        //  UsuarioDAO usuario = new UsuarioDAO();
        //  usuario.crear(nuevoUsuario);
        //  System.out.println(usuario.leerTodos());
        //  System.out.println(usuario.leer(1));
        //  usuario.eliminar(8); 
        //  nuevoUsuario.setUserName("nombre editado");
        //  usuario.actualizar(nuevoUsuario);
    }

}
