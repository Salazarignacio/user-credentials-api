package user.credentials.api;

import entities.CredencialUsuario;
import entities.Usuario;
import java.time.LocalDateTime;
import dao.CredencialUsuarioDAO;
import dao.UsuarioDAO;
import service.CredencialService;
import service.UsuarioService;

public class UserCredentialsApi {

    public static void main(String[] args) throws Exception {
          CredencialUsuario nuevaCredencial = new CredencialUsuario(false, "hashNuevo", "salt", LocalDateTime.now(), false);
          Usuario nuevoUsuario = new Usuario("Nuevo usuario15", "nuevousuario15@gmail.com", true, LocalDateTime.now(), nuevaCredencial);

          CredencialUsuarioDAO credencialDAO = new CredencialUsuarioDAO();
          CredencialService credencialService = new CredencialService(credencialDAO);
        // CredencialUsuario Services
        //  System.out.println(credencialService.findById(1));
        //  System.out.println(credencialService.findAll());
        //  credencialService.save(nuevaCredencial);
        //  credencialService.delete(45); 
        //  credencialService.save(nuevaCredencial);
        //  nuevaCredencial.setHashPassword("Editado 10:35");
        //  credencialService.update(nuevaCredencial);
        
        // CredencialUsuario DAO
        //  credencialDAO.crear(nuevaCredencial);
        //  nuevaCredencial.setHashPassword("Editado");
        //  System.out.println(credencialDAO.leer(1).getId());
        //  System.out.println(credencialDAO.leerTodos());
        //  credencialDAO.eliminar(9);
        //  nuevaCredencial.setHashPassword("testeando hash");
        //  credencialDAO.actualizar(nuevaCredencial);
        
        // UsuarioService
        UsuarioService uService = new UsuarioService(nuevoUsuario);
        //  System.out.println(uService.findById(1));
        //  System.out.println(uService.findAll());
        
        
        // UsuarioDAO
        //  UsuarioDAO usuario = new UsuarioDAO();
        //  usuario.crear(nuevoUsuario);
        //  System.out.println(usuario.leerTodos());
        //  System.out.println(usuario.leer(1));
        //  usuario.eliminar(8); 
        //  nuevoUsuario.setUserName("nombre editado");
        //  usuario.actualizar(nuevoUsuario);
    }

}
