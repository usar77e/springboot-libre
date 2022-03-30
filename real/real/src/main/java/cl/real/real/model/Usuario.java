package cl.real.real.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Schema(description = "Entidad de usuario")
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria del usuario")
    @Column(name = "usu_id")
    private Integer usu_id;

    @NotNull
    @Schema(description = "Nombre de usuario")
    @Column(name = "usu_nombre")
    private String usu_nombre;

    @NotNull
    @Schema(description = "Apellido del usuario")
    @Column(name = "usu_apellido")
    private String usu_apellido;

    @NotNull
    @Schema(description = "Estado, activo a desactivado de un usuario")
    @Column(name = "usu_estado")
    private Boolean usu_estado;

    @NotNull
    @Schema(description = "fecha de creacion de un usuario")
    @Column(name = "usu_creacion")
    private Date usu_creacion;

    @NotNull
    @Schema(description = "fecha de ultima modificacion de un usuario")
    @Column(name = "usu_modificacion")
    private Date usu_modificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deu_id", referencedColumnName = "deu_id")
    private DetalleUsuario detalleUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "perf_usu",
     joinColumns = { @JoinColumn(name = "usu_id", referencedColumnName = "usu_id") },
     inverseJoinColumns = {@JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id") })
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public Usuario(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public Usuario(Integer usu_id, String usu_nombre, String usu_apellido, Boolean usu_estado, Date usu_creacion, Date usu_modificacion) {
        this.usu_id = usu_id;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_estado = usu_estado;
        this.usu_creacion = usu_creacion;
        this.usu_modificacion = usu_modificacion;
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public Boolean getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(Boolean usu_estado) {
        this.usu_estado = usu_estado;
    }

    public Date getUsu_creacion() {
        return usu_creacion;
    }

    public void setUsu_creacion(Date usu_creacion) {
        this.usu_creacion = usu_creacion;
    }

    public Date getUsu_modificacion() {
        return usu_modificacion;
    }

    public void setUsu_modificacion(Date usu_modificacion) {
        this.usu_modificacion = usu_modificacion;
    }

    public DetalleUsuario getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(DetalleUsuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }
}
