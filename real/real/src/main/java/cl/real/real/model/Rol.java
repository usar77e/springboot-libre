package cl.real.real.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Schema(description = "Entidad de Rol de usuario")
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria del Rol")
    @Column(name = "id_rol")
    private Integer idRol;

    @NotNull
    @Schema(description = "Nombre de rol")
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Schema(description = "Estado, activo a desactivado de un rol")
    @Column(name = "estado")
    private Boolean estado;

    @NotNull
    @Schema(description = "fecha de creacion de un rol")
    @Column(name = "creacion")
    private Date creacion;

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Rol(Integer idRol, String nombre, Boolean estado, Date creacion) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.estado = estado;
        this.creacion = creacion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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
}
