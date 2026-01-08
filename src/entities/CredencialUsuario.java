package entities;

import java.time.LocalDateTime;

public class CredencialUsuario {

    private Long id;
    private Boolean eliminado;
    private String hashPassword;
    private String salt;
    private LocalDateTime ultimoCambio;
    private Boolean requireReset;

    public CredencialUsuario() {
    }

    ;

    public CredencialUsuario(Boolean eliminado, String hashPassword, String salt, LocalDateTime ultimoCambio, Boolean requireReset) {
        this.eliminado = eliminado;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.ultimoCambio = ultimoCambio;
        this.requireReset = requireReset;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUltimoCambio(LocalDateTime ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }

    public void setRequireReset(Boolean requireReset) {
        this.requireReset = requireReset;
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

    @Override
    public String toString() {
        return "CredencialUsuario{" + "id=" + id + ", eliminado=" + eliminado + ", hashPassword=" + hashPassword + ", salt=" + salt + ", ultimoCambio=" + ultimoCambio + ", requireReset=" + requireReset + '}';
    }

}
