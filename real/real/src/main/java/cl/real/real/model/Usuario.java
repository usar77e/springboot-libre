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
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotNull
    @Schema(description = "Nombre de usuario")
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Schema(description = "Apellido del usuario")
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Schema(description = "Estado, activo a desactivado de un usuario")
    @Column(name = "estado")
    private Boolean estado;

    @NotNull
    @Schema(description = "fecha de creacion de un usuario")
    @Column(name = "creacion")
    private Date creacion;

    @NotNull
    @Schema(description = "fecha de ultima modificacion de un usuario")
    @Column(name = "modificacion")
    private Date modificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dusuario", referencedColumnName = "id_dusuario")
    private DetalleUsuario detalleUsuario;

    /* modificacion de estructura de entidades, obj: simplificar 31/03/2022
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "perf_usu",
     joinColumns = { @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario") },
     inverseJoinColumns = {@JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil") })
    private Perfil perfil;
    */

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, Boolean estado, Date creacion, Date modificacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.creacion = creacion;
        this.modificacion = modificacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Date getModificacion() {
        return modificacion;
    }

    public void setModificacion(Date modificacion) {
        this.modificacion = modificacion;
    }

    public DetalleUsuario getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(DetalleUsuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

}
