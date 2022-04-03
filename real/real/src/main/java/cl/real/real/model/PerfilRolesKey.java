package cl.real.real.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PerfilRolesKey implements Serializable {

    @Column(name = "id_perfil")
    Integer idPerfil;

    @Column(name = "id_rol")
    Integer idRol;

    public PerfilRolesKey() {
    }

    public PerfilRolesKey(Integer idPerfil, Integer idRol) {
        this.idPerfil = idPerfil;
        this.idRol = idRol;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
