package entities;

import java.time.LocalDateTime;

public class CredencialUsuario {

    private Long id;
    private Boolean eliminado;
    private String hashPassword;
    private String salt;
    private LocalDateTime ultimoCambio;
    private Boolean requireReset;

    public CredencialUsuario(Long id, Boolean eliminado, String hashPassword, String salt, LocalDateTime ultimoCambio, Boolean requireReset) {
        this.id = id;
        this.eliminado = eliminado;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.ultimoCambio = ultimoCambio;
        this.requireReset = requireReset;
    }

    public Long getId() {
        return id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public String getSalt() {
        return salt;
    }

    public LocalDateTime getUltimoCambio() {
        return ultimoCambio;
    }

    public Boolean getRequireReset() {
        return requireReset;
    }

}
