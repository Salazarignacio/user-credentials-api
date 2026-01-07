package entities;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;
    private Boolean eliminado;
    private String userName;
    private String email;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
    private final CredencialUsuario credencial;

    public Usuario(String userName, String email, Boolean activo, LocalDateTime fechaRegistro, CredencialUsuario credencial) {
        this.eliminado = credencial.getEliminado();
        this.userName = userName;
        this.email = email;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.credencial = credencial;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", eliminado=" + eliminado + ", userName=" + userName + ", email=" + email + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro + ", credencial=" + credencial + '}';
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActivo() {
        return activo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public Long getCredencialId() {
        return credencial.getId();
    }
    public void setCredencialId(Long id) {
        this.credencial.setId(id);
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
