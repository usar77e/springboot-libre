package cl.real.real.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Schema(description = "Entidad del perfil de usuario")
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de los perfiles")
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @NotNull
    @Schema(description = "Nombre del perfil")
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Schema(description = "Estado, activo a desactivado de un perfil")
    @Column(name = "estado")
    private Boolean estado;

    @NotNull
    @Schema(description = "fecha de creacion de un perfil")
    @Column(name = "creacion")
    private Date creacion;

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;


    @ManyToMany
    @JoinTable(name = "perfil_roles",
    joinColumns = @JoinColumn(name = "per_id", referencedColumnName = "per_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
    private List<Rol> roles;

    public Perfil() {
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Integer idPerfil, String nombre, Boolean estado, Date creacion, Usuario usuario) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.estado = estado;
        this.creacion = creacion;
        this.usuario = usuario;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
