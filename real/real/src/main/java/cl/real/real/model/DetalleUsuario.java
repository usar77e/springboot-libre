package cl.real.real.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Schema(description = "Detalles del usuario")
@Entity
@Table(name = "detalleusuario")
public class DetalleUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de los detalles del usuario")
    @Column(name = "id_dusuario")
    private Integer idDUsuario;

    @Schema(description = "Correo del usuario")
    @Column(name = "correo")
    private String correo;

    @Schema(description = "Telefono del usuario")
    @Column(name = "telefono")
    private String telefono;

    @Schema(description = "Alias del usuario")
    @Column(name = "alias")
    private String alias;

    @NotNull
    @Schema(description = "Fecha de creacion de un usuario")
    @Column(name = "creacion")
    private Date creacion;

    @NotNull
    @Schema(description = "Fecha de ultima modificacion del detalle del usuario")
    @Column(name = "modificacion")
    private Date modificacion;

    @OneToOne(mappedBy = "detalleUsuario")
    private Usuario usuario;

    public DetalleUsuario() {
    }

    public DetalleUsuario(Integer idDUsuario) {
        this.idDUsuario = idDUsuario;
    }

    public DetalleUsuario(String correo) {
        this.correo = correo;
    }

    public DetalleUsuario(Integer idDUsuario, String correo, String telefono, String alias, Date creacion, Date modificacion) {
        this.idDUsuario = idDUsuario;
        this.correo = correo;
        this.telefono = telefono;
        this.alias = alias;
        this.creacion = creacion;
        this.modificacion = modificacion;
    }

    public Integer getIdDUsuario() {
        return idDUsuario;
    }

    public void setIdDUsuario(Integer idDUsuario) {
        this.idDUsuario = idDUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
