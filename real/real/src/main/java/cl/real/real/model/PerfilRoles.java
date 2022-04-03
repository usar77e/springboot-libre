package cl.real.real.model;

import javax.persistence.*;

@Entity
@Table(name = "perfil_roles")
public class PerfilRoles {

    @EmbeddedId
    PerfilRolesKey id;

    @ManyToOne
            @MapsId("idPerfil")
            @JoinColumn(name = "id_perfil")
    Perfil perfil;

    @ManyToOne
            @MapsId("idRol")
            @JoinColumn(name = "id_rol")
    Rol rol;

    public PerfilRoles() {
    }

    public PerfilRoles(PerfilRolesKey id) {
        this.id = id;
    }

    public PerfilRoles(PerfilRolesKey id, Perfil perfil, Rol rol) {
        this.id = id;
        this.perfil = perfil;
        this.rol = rol;
    }

    public PerfilRolesKey getId() {
        return id;
    }

    public void setId(PerfilRolesKey id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
